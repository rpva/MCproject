package pt.ulisboa.tecnico.sise.mc.project.insureappgroup10;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pt.ulisboa.tecnico.sise.mc.project.insureappgroup10.GlobalState;
import pt.ulisboa.tecnico.sise.mcproject_group5.adapters.ClaimItemAdapter;
import pt.ulisboa.tecnico.sise.mc.project.insureappgroup10.DataModel.ClaimItem ;

public class WSListClaimHistory extends AsyncTask <Integer, Void, List<ClaimItem> > {

    public final static String TAG = "ListClaimHistoryTask";

    private Context _activityContext;
    private ListView _listView;
    private GlobalState _gs;
    private boolean _isCacheValue;

    public WSListClaimHistory(Context context, ListView listView) {
        _activityContext = context;
        _gs = (GlobalState)(context.getApplicationContext());
        _listView = listView;
    }

    @Override
    protected List<ClaimItem> doInBackground(Integer... params) {

        List<ClaimItem> listClaimItems = new ArrayList<ClaimItem>();
        Integer sessionId = params[0];
        try {
            listClaimItems = WSHelper.listClaims(sessionId);
        } catch (Exception e) {

            try {
                listClaimItems = _gs.getCustomer().getClaimItemList();
                _isCacheValue = true;

            } catch (NullPointerException el) {
                Log.d(TAG, el.toString());
            }

        }
        return listClaimItems;
    }
    @Override
    protected void onPostExecute(List<ClaimItem> listClaimItems) {

        Log.d(TAG,"listClaimItems  " + listClaimItems);

        if(listClaimItems == null) {
            Toast.makeText(_gs,
                    "Server Error and no Claim Items in cache.\nPlease try again later.", Toast.LENGTH_LONG).show();
        } else if (listClaimItems.isEmpty()) {
            Toast.makeText(_gs,
                    "No claims in your history.\nGreat Customer", Toast.LENGTH_LONG).show();

        } else {
            if (_listView != null) {

                List<ClaimItem> dupList = new ArrayList<ClaimItem>();
                dupList.addAll(listClaimItems);

                Collections.reverse(dupList);
                ArrayAdapter<ClaimItem> claimItemArrayAdapter = new ClaimItemAdapter(_activityContext,
                        android.R.layout.simple_list_item_1, dupList);
                _listView.setAdapter(claimItemArrayAdapter);

                _gs.setCustomerClaimItemList(listClaimItems);
                _gs.writeCustomerInCache(_gs.getCustomer());

            }
        }
    }
}
