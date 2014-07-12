package com.nilhcem.hostseditor.task;

import com.nilhcem.hostseditor.R;
import com.nilhcem.hostseditor.core.Host;
import com.nilhcem.hostseditor.core.util.Log;

import java.util.List;

/**
 * AsyncTask that removes one or many host entries and triggers a {@code TaskCompletedEvent} event.
 */
public class RemoveHostsAsync extends GenericTaskAsync {

    private static final String TAG = RemoveHostsAsync.class.getSimpleName();

    @Override
    protected void process(Host... params) {
        Log.d(TAG, "Remove hosts");

        List<Host> hosts = mHostsManager.getHosts(false);
        for (Host host : params) {
            hosts.remove(host);
        }
    }

    @Override
    protected int getLoadingMsgRes() {
        return mFlagLoadingMsg ? R.string.loading_remove_single : R.string.loading_remove_multiple;
    }
}
