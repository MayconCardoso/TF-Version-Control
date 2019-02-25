package br.com.accera.mobile.tradeforceupdate.presentation.dashboard;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

import androidx.appcompat.widget.Toolbar;
import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseMvvmActivityDrawer;
import br.com.accera.mobile.tradeforceupdate.databinding.ActivityDashboardBinding;

/**
 * @author MAYCON CARDOSO on 07/01/2019.
 */
public class DashboardActivity extends BaseMvvmActivityDrawer<ActivityDashboardBinding, DashboardViewModel, DashboardNavigator> {

    @Override
    protected Toolbar getToolbar() {
        return mViewDataBinding.toolbar;
    }

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        registerObservables();
        mViewModel.synchronyzeInstanceInformation();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_dashboard;
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.dashboard_menu, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item ) {
        if( item.getItemId() == R.id.logout ) {
            mViewModel.tryLogout();
        }
        return super.onOptionsItemSelected( item );
    }

    private void registerObservables() {
        // Navigator
        mViewModel.getObservable().mAuthScreen.observe( this, ( __ ) -> mNavigator.goToLogin() );

        mViewModel.getObservable().mPieChartInstances.observe(this, this::setChart);
    }

    private void setChart(HashMap<String, Integer> instanceInformation) {
        ArrayList<Entry> numberOfInstances = new ArrayList<Entry>();
        ArrayList<String> versionName = new ArrayList<String>();
        int i = 0;
        for(Map.Entry<String, Integer> entry : instanceInformation.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            versionName.add(key);
            numberOfInstances.add(new Entry(value.floatValue(), i++));
        }
        PieDataSet dataSet = new PieDataSet(numberOfInstances, null);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        PieData data = new PieData(versionName, dataSet);
        data.setValueFormatter(new PercentFormatter());
        mViewDataBinding.piechart.setUsePercentValues(true);
        mViewDataBinding.piechart.setData(data);
        mViewDataBinding.piechart.setDescription(null);
        setLegend();
        mViewDataBinding.piechart.invalidate();
    }

    private void setLegend() {
        mViewDataBinding.piechart.getLegend().setFormSize(12f);
        mViewDataBinding.piechart.getLegend().setTextSize(12f);
        mViewDataBinding.piechart.getLegend().setForm(Legend.LegendForm.CIRCLE);
        mViewDataBinding.piechart.getLegend().setXEntrySpace(15);
        mViewDataBinding.piechart.getLegend().setYEntrySpace(15);
    }

}
