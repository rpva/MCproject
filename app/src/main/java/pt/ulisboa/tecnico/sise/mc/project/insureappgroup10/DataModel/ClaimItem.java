package pt.ulisboa.tecnico.sise.mc.project.insureappgroup10.DataModel;

public class ClaimItem {

    private String _title;
    private String _id;
    private String _plateNumber;
    private String _description;
    private String _dateOcorrence;



    public ClaimItem( String title, String plateNumber, String description, String dateOcorrence) {
        this._title = title;
        //this._id = id;
        this._plateNumber=plateNumber;
        this._dateOcorrence =dateOcorrence;
        this._description= description;

    }


    public String getTitle() {
        return _title;
    }

    public void setTitle(String claimTitle) {
        this._title = claimTitle;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) { this._id = id;
    }
    public String getPlateNumber() {
        return _plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this._plateNumber = plateNumber;
    }

    public String getDateOcorrence() {
        return _dateOcorrence;
    }

    public void setDateOcorrence(String dateOcorrence) { this._dateOcorrence = dateOcorrence;
    }

    public String getDesciption() {
        return _description;
    }

    public void setDescription(String description) { this._description = description;
    }

    @Override
    public String toString() {

        return "Claim Id " + _id + " " + _title +  " " + _plateNumber + _dateOcorrence+ " " + _description +  ".";
    }
    }

