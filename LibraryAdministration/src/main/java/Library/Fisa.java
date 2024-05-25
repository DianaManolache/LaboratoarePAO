package Library;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fisa {
    private int id;
    private int exemplarId;
    private Date dataImprumut;
    private Date dataReturn;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Fisa(int id, int exemplarId, Date dataImprumut, Date dataReturn) {
        this.id = id;
        this.exemplarId = exemplarId;
        this.dataImprumut = dataImprumut;
        this.dataReturn = dataReturn;
    }

    public int getId() {
        return id;
    }

    public int getExemplarId() {
        return exemplarId;
    }

    public Date getDataImprumut() {
        return dataImprumut;
    }

    public Date getDataReturn() {
        return dataReturn;
    }

    public void setId(int fisaId) {
        this.id = fisaId;
    }

    public void setDataReturn(java.sql.Date sqlDate) {
        this.dataReturn = sqlDate;
    }
}