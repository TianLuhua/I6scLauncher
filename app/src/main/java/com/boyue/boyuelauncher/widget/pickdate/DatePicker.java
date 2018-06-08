package com.boyue.boyuelauncher.widget.pickdate;

import android.content.Context;
import android.widget.TextView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.widget.pickdate.bean.DateType;
import com.boyue.boyuelauncher.widget.pickdate.genview.WheelGeneralAdapter;
import com.boyue.boyuelauncher.widget.pickdate.view.WheelView;

import java.util.Date;

/**
 * Created by codbking on 2016/8/10.
 */
class DatePicker extends BaseWheelPick {

    private static final String TAG = "WheelPicker";

    private WheelView yearView;
    private WheelView monthView;
    private WheelView dayView;
    private TextView weekView;
    private WheelView hourView;
    private WheelView minuteView;

    private TextView minuteLable;
    private TextView hourLable;
    private TextView dayLable;
    private TextView monthLable;
    private TextView yearLable;

    private Integer[] yearArr, mothArr, dayArr, hourArr, minutArr;
    private DatePickerHelper datePicker;

    public DateType type = DateType.TYPE_ALL;

    //开始时间
    private Date startDate = new Date();
    //年分限制，默认上下5年
    private int yearLimt = 5;

    private OnChangeLisener onChangeLisener;
    private int selectDay;

    //选择时间回调
    public void setOnChangeLisener(OnChangeLisener onChangeLisener) {
        this.onChangeLisener = onChangeLisener;
    }

    public DatePicker(Context context, DateType type) {
        super(context);
        if (this.type != null) {
            this.type = type;
        }
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setYearLimt(int yearLimt) {
        this.yearLimt = yearLimt;
    }

    //初始化值
    public void init() {

        this.yearLable = findViewById(R.id.year_lable);
        this.minuteLable = findViewById(R.id.minute_lable);
        this.dayLable = findViewById(R.id.day_lable);
        this.monthLable = findViewById(R.id.month_lable);
        this.hourLable = findViewById(R.id.hour_lable);

        this.yearView = findViewById(R.id.year);
        this.monthView = findViewById(R.id.month);
        this.dayView = findViewById(R.id.day);
        this.hourView = findViewById(R.id.hour);
        this.minuteView = findViewById(R.id.minute);

        this.weekView = findViewById(R.id.week);

        switch (type) {
            case TYPE_ALL:
                this.minuteView.setVisibility(VISIBLE);
                this.hourView.setVisibility(VISIBLE);
                this.weekView.setVisibility(VISIBLE);
                this.dayView.setVisibility(VISIBLE);
                this.monthView.setVisibility(VISIBLE);
                this.yearView.setVisibility(VISIBLE);

                this.yearLable.setVisibility(VISIBLE);
                this.monthLable.setVisibility(VISIBLE);
                this.dayLable.setVisibility(VISIBLE);
                this.hourLable.setVisibility(VISIBLE);
                this.minuteLable.setVisibility(VISIBLE);

                break;
            case TYPE_YMDHM:
                this.minuteView.setVisibility(VISIBLE);
                this.hourView.setVisibility(VISIBLE);
                this.weekView.setVisibility(GONE);
                this.dayView.setVisibility(VISIBLE);
                this.monthView.setVisibility(VISIBLE);
                this.yearView.setVisibility(VISIBLE);

                this.yearLable.setVisibility(VISIBLE);
                this.monthLable.setVisibility(VISIBLE);
                this.dayLable.setVisibility(VISIBLE);
                this.hourLable.setVisibility(VISIBLE);
                this.minuteLable.setVisibility(VISIBLE);
                break;
            case TYPE_YMDH:
                this.minuteView.setVisibility(GONE);
                this.hourView.setVisibility(VISIBLE);
                this.weekView.setVisibility(GONE);
                this.dayView.setVisibility(VISIBLE);
                this.monthView.setVisibility(VISIBLE);
                this.yearView.setVisibility(VISIBLE);
                this.yearLable.setVisibility(VISIBLE);
                this.monthLable.setVisibility(VISIBLE);
                this.dayLable.setVisibility(VISIBLE);
                this.hourLable.setVisibility(VISIBLE);
                this.minuteLable.setVisibility(GONE);
                break;
            case TYPE_YMD:
                this.minuteView.setVisibility(GONE);
                this.hourView.setVisibility(GONE);
                this.weekView.setVisibility(GONE);
                this.dayView.setVisibility(VISIBLE);
                this.monthView.setVisibility(VISIBLE);
                this.yearView.setVisibility(VISIBLE);


                this.yearLable.setVisibility(VISIBLE);
                this.monthLable.setVisibility(VISIBLE);
                this.dayLable.setVisibility(VISIBLE);
                this.hourLable.setVisibility(GONE);
                this.minuteLable.setVisibility(GONE);
                break;
            case TYPE_HM:
                this.minuteView.setVisibility(VISIBLE);
                this.hourView.setVisibility(VISIBLE);
                this.weekView.setVisibility(GONE);
                this.dayView.setVisibility(GONE);
                this.monthView.setVisibility(GONE);
                this.yearView.setVisibility(GONE);

                this.yearLable.setVisibility(GONE);
                this.monthLable.setVisibility(GONE);
                this.dayLable.setVisibility(GONE);
                this.hourLable.setVisibility(VISIBLE);
                this.minuteLable.setVisibility(VISIBLE);
                break;
        }

        datePicker = new DatePickerHelper();
        datePicker.setStartDate(startDate, yearLimt);

        dayArr = datePicker.genDay();
        yearArr = datePicker.genYear();
        mothArr = datePicker.genMonth();
        hourArr = datePicker.genHour();
        minutArr = datePicker.genMinut();

        weekView.setText(datePicker.getDisplayStartWeek());

        setWheelListener(yearView, yearArr, false);
        setWheelListener(monthView, mothArr, true);
        setWheelListener(dayView, dayArr, true);
        setWheelListener(hourView, hourArr, true);
        setWheelListener(minuteView, minutArr, true);

        yearView.setCurrentItem(datePicker.findIndextByValue(datePicker.getToady(DatePickerHelper.Type.YEAR), yearArr));
        monthView.setCurrentItem(datePicker.findIndextByValue(datePicker.getToady(DatePickerHelper.Type.MOTH), mothArr));
        dayView.setCurrentItem(datePicker.findIndextByValue(datePicker.getToady(DatePickerHelper.Type.DAY), dayArr));
        hourView.setCurrentItem(datePicker.findIndextByValue(datePicker.getToady(DatePickerHelper.Type.HOUR), hourArr));
        minuteView.setCurrentItem(datePicker.findIndextByValue(datePicker.getToady(DatePickerHelper.Type.MINUTE), minutArr));

    }


    protected String[] convertData(WheelView wheelView, Integer[] data) {
        if (wheelView == yearView) {
//            return datePicker.getDisplayValue(data, "年");
            return datePicker.getDisplayValue(data, "");
        } else if (wheelView == monthView) {
//            return datePicker.getDisplayValue(data, "月");
            return datePicker.getDisplayValue(data, "");
        } else if (wheelView == dayView) {
//            return datePicker.getDisplayValue(data, "日");
            return datePicker.getDisplayValue(data, "");
        } else if (wheelView == hourView) {
            return datePicker.getDisplayValue(data, "");
        } else if (wheelView == minuteView) {
            return datePicker.getDisplayValue(data, "");
        }
        return new String[0];
    }

    @Override
    protected int getLayout() {
        return R.layout.dialog_pickdate;
    }

    @Override
    protected int getItemHeight() {
        return dayView.getItemHeight();
    }


    @Override
    protected void setData(Object[] datas) {
    }

    private void setChangeDaySelect(int year, int moth) {
        dayArr = datePicker.genDay(year, moth);
        WheelGeneralAdapter adapter = (WheelGeneralAdapter) dayView.getViewAdapter();
        adapter.setData(convertData(dayView, dayArr));

        int indxt = datePicker.findIndextByValue(selectDay, dayArr);
        if (indxt == -1) {
            dayView.setCurrentItem(0);
        } else {
            dayView.setCurrentItem(indxt);
        }
    }

    @Override
    public void onChanged(WheelView wheel, int oldValue, int newValue) {

        int year = yearArr[yearView.getCurrentItem()];
        int moth = mothArr[monthView.getCurrentItem()];
        int day = dayArr[dayView.getCurrentItem()];
        int hour = hourArr[hourView.getCurrentItem()];
        int minut = minutArr[minuteView.getCurrentItem()];

        if (wheel == yearView || wheel == monthView) {
            setChangeDaySelect(year, moth);
        } else {
            selectDay = day;
        }

        if (wheel == yearView || wheel == monthView || wheel == dayView) {
            weekView.setText(datePicker.getDisplayWeek(year, moth, day));
        }

        if (onChangeLisener != null) {
            onChangeLisener.onChanged(DateUtils.getDate(year, moth, day, hour, minut));
        }

    }

    @Override
    public void onScrollingStarted(WheelView wheel) {
    }

    @Override
    public void onScrollingFinished(WheelView wheel) {
    }


    //获取选中日期
    public Date getSelectDate() {

        int year = yearArr[yearView.getCurrentItem()];
        int moth = mothArr[monthView.getCurrentItem()];
        int day = dayArr[dayView.getCurrentItem()];
        int hour = hourArr[hourView.getCurrentItem()];
        int minut = minutArr[minuteView.getCurrentItem()];

        return DateUtils.getDate(year, moth, day, hour, minut);

    }


}
