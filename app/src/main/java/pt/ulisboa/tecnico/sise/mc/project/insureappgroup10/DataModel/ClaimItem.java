package pt.ulisboa.tecnico.sise.mc.project.insureappgroup10.DataModel;

import java.io.Serializable;


public class ClaimItem  implements Serializable{
    private static final long serialVersionUID = 80004589896989016L;
    protected final int _id;
    protected final String _title;

    public ClaimItem( String title, int id ) {
        this._title = title;
        this._id = id;

    }


    public int getId() {
        return _id;
    }

    public String getTitle() {
        return _title;
    }




    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ClaimItem)) {
            return false;
        }
        ClaimItem other = (ClaimItem) obj;
        if (_id != other._id) {
            return false;
        }
        return true;
    }


    @Override

    public String toString() {
        return "Claim Id: " + _id + ", " +
                "Claim Title: " + _title + ".";
    }
    }

