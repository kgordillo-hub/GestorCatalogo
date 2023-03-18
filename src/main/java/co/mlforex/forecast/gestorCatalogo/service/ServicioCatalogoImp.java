package co.mlforex.forecast.gestorCatalogo.service;

import co.mlforex.forecast.gestorCatalogo.model.MiCatalogoInfo;
import co.mlforex.forecast.gestorCatalogo.model.TransaccionInfo;
import co.mlforex.forecast.gestorCatalogo.notification.NotificadorSns;
import co.mlforex.forecast.gestorCatalogo.repository.FullCatalogInfo;
import co.mlforex.forecast.gestorCatalogo.repository.MyCatalogInfo;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioCatalogoImp implements ServicioCatalogo {

    @Autowired
    FullCatalogInfo fullCatalogInfo;

    @Autowired
    MyCatalogInfo myCatalogInfo;

    @Value("${aws.sns.topic.genEnvIn.arn}")
    String topicArnEnvIn;

    @Override
    public Boolean agregarCatalogoGeneral(TransaccionInfo transaccionInfo) {
        String UID = transaccionInfo.generateUID();
        if (fullCatalogInfo.findById(UID).isEmpty()) {
            transaccionInfo.setUID(UID);
            fullCatalogInfo.save(transaccionInfo);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public List<TransaccionInfo> consultarCatalogoPublico() {
        final List<TransaccionInfo> transaccionInfoList = new ArrayList<>();
        final Iterable<TransaccionInfo> transactions = fullCatalogInfo.findAll();
        if (transactions != null) {
            final Iterator<TransaccionInfo> it = transactions.iterator();
            while (it.hasNext()) {
                final TransaccionInfo ti = it.next();
                if (ti.getMensaje().getEsPublico() != null && ti.getMensaje().getEsPublico()) {
                    transaccionInfoList.add(ti);
                }
            }
        }
        return transaccionInfoList;
    }


    @Override
    public List<MiCatalogoInfo> consultarCatalogoPrivado(String idUsuario) {
        final List<MiCatalogoInfo> miCatalogList = new ArrayList<>();
        final Iterable<MiCatalogoInfo> miCatalogInfo = myCatalogInfo.findAll();
        if (miCatalogInfo != null) {
            final Iterator<MiCatalogoInfo> mcIt = miCatalogInfo.iterator();
            while (mcIt.hasNext()) {
                final MiCatalogoInfo mc = mcIt.next();
                if (mc.getIdUsuario().equalsIgnoreCase(idUsuario)) {
                    miCatalogList.add(mc);
                }
            }
        }
        return miCatalogList;
    }

    @Override
    public Boolean agregarCatalogoPrivado(MiCatalogoInfo catalogoInfo) {
        Integer consecutivo = 1;
        catalogoInfo.setConsecutivo(consecutivo);
        String UID = catalogoInfo.generateUID();
        Optional<MiCatalogoInfo> mciO = myCatalogInfo.findById(UID);
        while (!mciO.isEmpty()) {
            consecutivo = consecutivo + 1;
            catalogoInfo.setConsecutivo(consecutivo);
            UID = catalogoInfo.generateUID();
            mciO = myCatalogInfo.findById(UID);
        }
        final String message = new GsonBuilder().disableHtmlEscaping().create().toJson(catalogoInfo);
        new NotificadorSns().publishMessageSns(message, topicArnEnvIn);
        catalogoInfo.setUID(UID);
        catalogoInfo.setEnPreparacion(Boolean.TRUE);
        myCatalogInfo.save(catalogoInfo);
        return Boolean.TRUE;
    }

    @Override
    public void actualizarMiCatalogo(MiCatalogoInfo miCatalogoInfo, String evento) {
        if (evento.equalsIgnoreCase("aprovisionamiento")) {
            MiCatalogoInfo mci = getFirstOccurence(miCatalogoInfo, Boolean.TRUE);
            if (mci != null ) {
                mci.setEnPreparacion(Boolean.FALSE);
                mci.setIpAPI(miCatalogoInfo.getIpAPI());
                mci.setNumeroPuerto(miCatalogoInfo.getNumeroPuerto());
                myCatalogInfo.save(mci);
            }
        } else if (evento.equalsIgnoreCase("entrenamiento")) {
            MiCatalogoInfo mci = getFirstOccurence(miCatalogoInfo, Boolean.FALSE);
            if (mci != null ) {
                mci.setEnEntrenamiento(Boolean.FALSE);
                myCatalogInfo.save(mci);
            }
        }
    }

    private MiCatalogoInfo getFirstOccurence(MiCatalogoInfo miCatalogoInfo, Boolean estado) {
        final Iterable<MiCatalogoInfo> myCatalog = myCatalogInfo.findAll();
        if (myCatalog != null) {
            final Iterator<MiCatalogoInfo> it = myCatalog.iterator();
            while (it.hasNext()) {
                MiCatalogoInfo mci = it.next();
                if (mci.getNombreApp().equalsIgnoreCase(miCatalogoInfo.getNombreApp())
                        && mci.getVersion().equalsIgnoreCase(miCatalogoInfo.getVersion())
                        && mci.getIdUsuario().equalsIgnoreCase(miCatalogoInfo.getIdUsuario())
                        && mci.getEnPreparacion() == estado && mci.getEnEntrenamiento() == null) {
                    return mci;
                }
            }
        }
        return null;
    }
}
