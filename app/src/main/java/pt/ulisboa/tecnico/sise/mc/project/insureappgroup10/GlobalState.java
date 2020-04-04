package pt.ulisboa.tecnico.sise.mc.project.insureappgroup10;

import android.app.Application;

import java.util.ArrayList;

import pt.ulisboa.tecnico.sise.mc.project.insureappgroup10.DataModel.ClaimItem;
import pt.ulisboa.tecnico.sise.mc.project.insureappgroup10.DataModel.Customer;

public class GlobalState extends Application {
    private ArrayList<ClaimItem> _claimItemList;
    private int _sessionId = -1;
    private Customer _customer;

    public void setClaimItemList(ArrayList<ClaimItem> claimItemList) {
        _claimItemList = claimItemList;
    }

    public ArrayList<ClaimItem> getClaimItemList() {
        return _claimItemList;
    }

    public Customer getCustomer() {
        return _customer;
    }

    public void setCustomer(Customer newCustomer) {
        // if a customer already existed then it is necessary to clone the
        // claimRecords and plateLists here
        Customer oldCustomer = _customer;
        this._customer = newCustomer;

        if (oldCustomer != null) {
            this._customer.setClaimItemList(oldCustomer.getClaimItemList());
            this._customer.setClaimRecordList(oldCustomer.getClaimRecordList());
        }
    }




}