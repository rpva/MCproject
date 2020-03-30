package pt.ulisboa.tecnico.sise.mc.project.insureappgroup10;

import android.app.Application;

import java.util.ArrayList;

import pt.ulisboa.tecnico.sise.mc.project.insureappgroup10.DataModel.ClaimItem;

public class GlobalState extends Application {
    private ArrayList<ClaimItem> _claimItemList;

    public void setClaimItemList(ArrayList<ClaimItem> claimItemList) {
        _claimItemList = claimItemList;
    }

    public ArrayList<ClaimItem> getClaimItemList() {
        return _claimItemList;
    }
}