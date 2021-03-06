package hznj.com.zhongcexiangjiao.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.tijiaoBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 数据录入界面
 */
public class BuildingCSActivity extends AppCompatActivity implements View.OnClickListener {

    private String dateCode;
    private String typeCode;
    private String cm1;
    private String cm1_2;
    private String cm1_3;
    private String cm1_4;
    private String cm2;
    private String cm3;
    private String cm4;
    private String[] SP_TYPE = new String[]{"合格", "不合格"};

    private String   sp_type;
    private EditText bd_cx_pingmian1;
    private EditText bd_cx_pingmian2;
    private EditText bd_cx_pingmian3;
    private EditText bd_cx_pingmian4;
    private EditText bd_cx_gangsiquan1;
    private EditText bd_cx_gangsiquan2;
    private EditText bd_cx_gangsiquan3;
    private EditText bd_cx_gangsiquan4;
    private EditText bd_cx_chengqi1;
    private EditText bd_cx_chengqi2;
    private EditText bd_cx_chengqi3;
    private EditText bd_cx_chengqi4;
    private EditText bd_cx_yudingxing;
    private EditText bd_cx_dingxing;
    private EditText bd_cx_chaodingxing;
    private EditText bd_cx_daishugu;

    private EditText bd_bj_taice1;
    private EditText bd_bj_taice2;
    private EditText bd_bj_taice3;
    private EditText bd_bj_taice4;
    private EditText bd_bj_neichenceng1;
    private EditText bd_bj_neichenceng2;
    private EditText bd_bj_neichenceng3;
    private EditText bd_bj_neichenceng4;
    private EditText bd_bj_gangbao1;
    private EditText bd_bj_gangbao2;
    private EditText bd_bj_gangbao3;
    private EditText bd_bj_gangbao4;
    private EditText bd_bj_taiti1;
    private EditText bd_bj_taiti2;
    private EditText bd_bj_taiti3;
    private EditText bd_bj_taiti4;
    private EditText bd_bj_dianjiao1;
    private EditText bd_bj_dianjiao2;
    private EditText bd_bj_dianjiao3;
    private EditText bd_bj_dianjiao4;
    private EditText bd_bj_daishuceng1_1;
    private EditText bd_bj_daishuceng1_2;
    private EditText bd_bj_daishuceng1_3;
    private EditText bd_bj_daishuceng1_4;
    private EditText bd_bj_daishuceng2_1;
    private EditText bd_bj_daishuceng2_2;
    private EditText bd_bj_daishuceng2_3;
    private EditText bd_bj_daishuceng2_4;
    private EditText bd_bj_daishuceng3_1;
    private EditText bd_bj_daishuceng3_2;
    private EditText bd_bj_daishuceng3_3;
    private EditText bd_bj_daishuceng3_4;
    private EditText bd_bj_daishuceng4_1;
    private EditText bd_bj_daishuceng4_2;
    private EditText bd_bj_daishuceng4_3;
    private EditText bd_bj_daishuceng4_4;
    private EditText bd_bj_taimian1;
    private EditText bd_bj_taimian2;
    private EditText bd_bj_taimian3;
    private EditText bd_bj_taimian4;
    private EditText bd_th_taice1;
    private EditText bd_bj_fugu;
    private EditText bd_bj_zhugu;
    private EditText bd_th_taice2;
    private Spinner  bd_th_taice3;

    private EditText bd_th_neichenceng1;
    private EditText bd_th_neichenceng2;
    private Spinner  bd_th_neichenceng3;

    private EditText bd_th_gangbaoTH1;
    private EditText bd_th_gangbaoTH2;
    private Spinner  bd_th_gangbaoTH3;

    private EditText bd_th_taiti1;
    private EditText bd_th_taiti2;
    private Spinner  bd_th_taiti3;

    private EditText bd_th_dianjiaoTH1;
    private EditText bd_th_dianjiaoTH2;
    private Spinner  bd_th_dianjiaoTH3;

    private EditText bd_th_daishuceng1_1;
    private EditText bd_th_daishuceng1_2;
    private Spinner  bd_th_daishuceng1_3;

    private EditText bd_th_daishuceng2_1;
    private EditText bd_th_daishuceng2_2;
    private Spinner  bd_th_daishuceng2_3;

    private EditText bd_th_daishuceng3_1;
    private EditText bd_th_daishuceng3_2;
    private Spinner  bd_th_daishuceng3_3;

    private EditText bd_th_daishuceng4_1;
    private EditText bd_th_daishuceng4_2;
    private Spinner  bd_th_daishuceng4_3;

    private EditText bd_cx_tiehegu;
    private Spinner  bd_th_bzpwaiguan;
    private Spinner  bd_th_dingweijiaodu;
    private Spinner  bd_th_taimian;
    private Spinner  bd_th_xianyong;
    private Spinner  bd_th_sanxian;

    private String cx_pingmian1;
    private String cx_pingmian2;
    private String cx_pingmian3;
    private String cx_pingmian4;
    private String cx_gangsiquan1;
    private String cx_gangsiquan2;
    private String cx_gangsiquan3;
    private String cx_gangsiquan4;
    private String cx_chengqi1;
    private String cx_chengqi2;
    private String cx_chengqi3;
    private String cx_chengqi4;
    private String cx_yudingxing;
    private String cx_dingxing;
    private String cx_chaodingxing;
    private String cx_daishugu;
    private String cx_tiehegu;
    private String bj_taice1;
    private String bj_taice2;
    private String bj_taice3;
    private String bj_taice4;
    private String bj_neichenceng1;
    private String bj_neichenceng2;
    private String bj_neichenceng3;
    private String bj_neichenceng4;
    private String bj_gangbao1;
    private String bj_gangbao2;
    private String bj_gangbao3;
    private String bj_gangbao4;
    private String bj_taiti1;
    private String bj_taiti2;
    private String bj_taiti3;
    private String bj_taiti4;
    private String bj_dianjiao1;
    private String bj_dianjiao2;
    private String bj_dianjiao3;
    private String bj_dianjiao4;
    private String bj_daishuceng1_1;
    private String bj_daishuceng1_2;
    private String bj_daishuceng1_3;
    private String bj_daishuceng1_4;
    private String bj_daishuceng2_1;
    private String bj_daishuceng2_2;
    private String bj_daishuceng2_3;
    private String bj_daishuceng2_4;
    private String bj_daishuceng3_1;
    private String bj_daishuceng3_2;
    private String bj_daishuceng3_3;
    private String bj_daishuceng3_4;
    private String bj_daishuceng4_1;
    private String bj_daishuceng4_2;
    private String bj_daishuceng4_3;
    private String bj_daishuceng4_4;
    private String bj_taimian1;
    private String bj_taimian2;
    private String bj_taimian3;
    private String bj_taimian4;
    private String bj_zhugu;
    private String bj_fugu;
    private String th_taice1;
    private String th_taice2;
    private String spr_taice3;

    private String th_neichenceng1;
    private String th_neichenceng2;
    private String spr_neichenceng3;

    private String th_gangbaoTH1;
    private String th_gangbaoTH2;
    private String spr_gangbaoTH3;

    private String th_taiti1;
    private String th_taiti2;
    private String spr_taiti3;

    private String th_dianjiaoTH1;
    private String th_dianjiaoTH2;
    private String spr_dianjiaoTH3;

    private String th_daishuceng1_1;
    private String th_daishuceng1_2;
    private String spr_daishuceng1_3;

    private String th_daishuceng2_1;
    private String th_daishuceng2_2;
    private String spr_daishuceng2_3;

    private String th_daishuceng3_1;
    private String th_daishuceng3_2;
    private String spr_daishuceng3_3;

    private String th_daishuceng4_1;
    private String th_daishuceng4_2;
    private String spr_daishuceng4_3;

    private String   riqi;
    private String   guige;
    private String   cengji;
    private String   cengji_1;
    private String   huawen;
    private String   xilie;
    private String   bc;
    private String   bz;
    private String   jt;
    private EditText bd_th_taipeizhouchang;
    private EditText bd_th_taitigunya;

    private String spr_waiguan;
    private String spr_jiaodu;
    private String spr_taimian;
    private String spr_xianyong;
    private String spr_sanxian;
    private Button bd_biaozhunshuju;
    private String processno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_cs);
        riqi = getIntent().getExtras().getString("riqi");
        guige = getIntent().getExtras().getString("guige");
        cengji = getIntent().getExtras().getString("cengji");
        // cengji = cengji_1.replace("+", "%2B");
        huawen = getIntent().getExtras().getString("huawen");
        xilie = getIntent().getExtras().getString("xilie");
        bc = getIntent().getExtras().getString("bc");
        bz = getIntent().getExtras().getString("bz");
        jt = getIntent().getExtras().getString("jt");
        processno = getIntent().getExtras().getString("processno");
        //processno
        // Toast.makeText(getApplicationContext(), riqi + "--" + guige + "--" + this.cengji + "--" + huawen + "--" + xilie + "--" + bc + "--" + bz + "--" + jt, Toast.LENGTH_SHORT).show();
        initView();
        initData();

    }


    private void initView() {
        /**
         * 成型机参数
         */
        bd_cx_pingmian1 = (EditText) findViewById(R.id.bd_cx_pingmian1);
        bd_cx_pingmian2 = (EditText) findViewById(R.id.bd_cx_pingmian2);
        bd_cx_pingmian3 = (EditText) findViewById(R.id.bd_cx_pingmian3);
        bd_cx_pingmian4 = (EditText) findViewById(R.id.bd_cx_pingmian4);

        bd_cx_gangsiquan1 = (EditText) findViewById(R.id.bd_cx_gangsiquan1);
        bd_cx_gangsiquan2 = (EditText) findViewById(R.id.bd_cx_gangsiquan2);
        bd_cx_gangsiquan3 = (EditText) findViewById(R.id.bd_cx_gangsiquan3);
        bd_cx_gangsiquan4 = (EditText) findViewById(R.id.bd_cx_gangsiquan4);
        bd_cx_chengqi1 = (EditText) findViewById(R.id.bd_cx_chengqi1);
        bd_cx_chengqi2 = (EditText) findViewById(R.id.bd_cx_chengqi2);
        bd_cx_chengqi3 = (EditText) findViewById(R.id.bd_cx_chengqi3);
        bd_cx_chengqi4 = (EditText) findViewById(R.id.bd_cx_chengqi4);
        bd_cx_yudingxing = (EditText) findViewById(R.id.bd_cx_yudingxing);
        bd_cx_dingxing = (EditText) findViewById(R.id.bd_cx_dingxing);
        bd_cx_chaodingxing = (EditText) findViewById(R.id.bd_cx_chaodingxing);
        bd_cx_daishugu = (EditText) findViewById(R.id.bd_cx_daishugu);
        bd_cx_tiehegu = (EditText) findViewById(R.id.bd_cx_tiehegu);
        /**
         *  部件参数
         */

        bd_bj_taice1 = (EditText) findViewById(R.id.bd_bj_taice1);
        bd_bj_taice2 = (EditText) findViewById(R.id.bd_bj_taice2);
        bd_bj_taice3 = (EditText) findViewById(R.id.bd_bj_taice3);
        bd_bj_taice4 = (EditText) findViewById(R.id.bd_bj_taice4);

        bd_bj_neichenceng1 = (EditText) findViewById(R.id.bd_bj_neichenceng1);
        bd_bj_neichenceng2 = (EditText) findViewById(R.id.bd_bj_neichenceng2);
        bd_bj_neichenceng3 = (EditText) findViewById(R.id.bd_bj_neichenceng3);
        bd_bj_neichenceng4 = (EditText) findViewById(R.id.bd_bj_neichenceng4);

        bd_bj_gangbao1 = (EditText) findViewById(R.id.bd_bj_gangbao1);
        bd_bj_gangbao2 = (EditText) findViewById(R.id.bd_bj_gangbao2);
        bd_bj_gangbao3 = (EditText) findViewById(R.id.bd_bj_gangbao3);
        bd_bj_gangbao4 = (EditText) findViewById(R.id.bd_bj_gangbao4);

        bd_bj_taiti1 = (EditText) findViewById(R.id.bd_bj_taiti1);
        bd_bj_taiti2 = (EditText) findViewById(R.id.bd_bj_taiti2);
        bd_bj_taiti3 = (EditText) findViewById(R.id.bd_bj_taiti3);
        bd_bj_taiti4 = (EditText) findViewById(R.id.bd_bj_taiti4);

        bd_bj_dianjiao1 = (EditText) findViewById(R.id.bd_bj_dianjiao1);
        bd_bj_dianjiao2 = (EditText) findViewById(R.id.bd_bj_dianjiao2);
        bd_bj_dianjiao3 = (EditText) findViewById(R.id.bd_bj_dianjiao3);
        bd_bj_dianjiao4 = (EditText) findViewById(R.id.bd_bj_dianjiao4);

        bd_bj_daishuceng1_1 = (EditText) findViewById(R.id.bd_bj_daishuceng1_1);
        bd_bj_daishuceng1_2 = (EditText) findViewById(R.id.bd_bj_daishuceng1_2);
        bd_bj_daishuceng1_3 = (EditText) findViewById(R.id.bd_bj_daishuceng1_3);
        bd_bj_daishuceng1_4 = (EditText) findViewById(R.id.bd_bj_daishuceng1_4);

        bd_bj_daishuceng2_1 = (EditText) findViewById(R.id.bd_bj_daishuceng2_1);
        bd_bj_daishuceng2_2 = (EditText) findViewById(R.id.bd_bj_daishuceng2_2);
        bd_bj_daishuceng2_3 = (EditText) findViewById(R.id.bd_bj_daishuceng2_3);
        bd_bj_daishuceng2_4 = (EditText) findViewById(R.id.bd_bj_daishuceng2_4);

        bd_bj_daishuceng3_1 = (EditText) findViewById(R.id.bd_bj_daishuceng3_1);
        bd_bj_daishuceng3_2 = (EditText) findViewById(R.id.bd_bj_daishuceng3_2);
        bd_bj_daishuceng3_3 = (EditText) findViewById(R.id.bd_bj_daishuceng3_3);
        bd_bj_daishuceng3_4 = (EditText) findViewById(R.id.bd_bj_daishuceng3_4);

        bd_bj_daishuceng4_1 = (EditText) findViewById(R.id.bd_bj_daishuceng4_1);
        bd_bj_daishuceng4_2 = (EditText) findViewById(R.id.bd_bj_daishuceng4_2);
        bd_bj_daishuceng4_3 = (EditText) findViewById(R.id.bd_bj_daishuceng4_3);
        bd_bj_daishuceng4_4 = (EditText) findViewById(R.id.bd_bj_daishuceng4_4);

        bd_bj_taimian1 = (EditText) findViewById(R.id.bd_bj_taimian1);
        bd_bj_taimian2 = (EditText) findViewById(R.id.bd_bj_taimian2);
        bd_bj_taimian3 = (EditText) findViewById(R.id.bd_bj_taimian3);
        bd_bj_taimian4 = (EditText) findViewById(R.id.bd_bj_taimian4);

        bd_bj_zhugu = (EditText) findViewById(R.id.bd_bj_zhugu);
        bd_bj_fugu = (EditText) findViewById(R.id.bd_bj_fugu);

        //设置默认数值
       /* bd_bj_taice1.setText("651");
        bd_bj_taice2.setText("651");
        bd_bj_taice3.setText("651");
        bd_bj_taice4.setText("651");
        bd_bj_neichenceng1.setText("650");
        bd_bj_neichenceng2.setText("650");
        bd_bj_neichenceng3.setText("650");
        bd_bj_neichenceng4.setText("650");
        bd_bj_gangbao1.setText("120");
        bd_bj_gangbao2.setText("120");
        bd_bj_gangbao3.setText("120");
        bd_bj_gangbao4.setText("120");
        bd_bj_taiti1.setText("740");
        bd_bj_taiti2.setText("740");
        bd_bj_taiti3.setText("740");
        bd_bj_taiti4.setText("740");
        bd_bj_dianjiao1.setText("92");
        bd_bj_dianjiao2.setText("92");
        bd_bj_dianjiao3.setText("92");
        bd_bj_dianjiao4.setText("92");
        bd_bj_daishuceng1_1.setText("100");
        bd_bj_daishuceng1_2.setText("100");
        bd_bj_daishuceng1_3.setText("100");
        bd_bj_daishuceng1_4.setText("100");
        bd_bj_daishuceng2_1.setText("100");
        bd_bj_daishuceng2_2.setText("100");
        bd_bj_daishuceng2_3.setText("100");
        bd_bj_daishuceng2_4.setText("100");
        bd_bj_daishuceng3_1.setText("100");
        bd_bj_daishuceng3_2.setText("100");
        bd_bj_daishuceng3_3.setText("100");
        bd_bj_daishuceng3_4.setText("100");
        bd_bj_daishuceng4_1.setText("100");
        bd_bj_daishuceng4_2.setText("100");
        bd_bj_daishuceng4_3.setText("100");
        bd_bj_daishuceng4_4.setText("100");
        bd_bj_taimian1.setText("ceshi");
        bd_bj_taimian2.setText("ceshi");
        bd_bj_taimian3.setText("ceshi");
        bd_bj_taimian4.setText("ceshi");
        bd_bj_zhugu.setText("1");
        bd_bj_fugu.setText("1");*/

        /***
         * 贴合位置参数
         */
        bd_th_taice1 = (EditText) findViewById(R.id.bd_th_taice1);
        bd_th_taice2 = (EditText) findViewById(R.id.bd_th_taice2);
        bd_th_taice3 = (Spinner) findViewById(R.id.bd_th_taice3);

        bd_th_neichenceng1 = (EditText) findViewById(R.id.bd_th_neichenceng1);
        bd_th_neichenceng2 = (EditText) findViewById(R.id.bd_th_neichenceng2);
        bd_th_neichenceng3 = (Spinner) findViewById(R.id.bd_th_neichenceng3);

        bd_th_gangbaoTH1 = (EditText) findViewById(R.id.bd_th_gangbaoTH1);
        bd_th_gangbaoTH2 = (EditText) findViewById(R.id.bd_th_gangbaoTH2);
        bd_th_gangbaoTH3 = (Spinner) findViewById(R.id.bd_th_gangbaoTH3);

        bd_th_taiti1 = (EditText) findViewById(R.id.bd_th_taiti1);
        bd_th_taiti2 = (EditText) findViewById(R.id.bd_th_taiti2);
        bd_th_taiti3 = (Spinner) findViewById(R.id.bd_th_taiti3);

        bd_th_dianjiaoTH1 = (EditText) findViewById(R.id.bd_th_dianjiaoTH1);
        bd_th_dianjiaoTH2 = (EditText) findViewById(R.id.bd_th_dianjiaoTH2);
        bd_th_dianjiaoTH3 = (Spinner) findViewById(R.id.bd_th_dianjiaoTH3);

        bd_th_daishuceng1_1 = (EditText) findViewById(R.id.bd_th_daishuceng1_1);
        bd_th_daishuceng1_2 = (EditText) findViewById(R.id.bd_th_daishuceng1_2);
        bd_th_daishuceng1_3 = (Spinner) findViewById(R.id.bd_th_daishuceng1_3);

        bd_th_daishuceng2_1 = (EditText) findViewById(R.id.bd_th_daishuceng2_1);
        bd_th_daishuceng2_2 = (EditText) findViewById(R.id.bd_th_daishuceng2_2);
        bd_th_daishuceng2_3 = (Spinner) findViewById(R.id.bd_th_daishuceng2_3);

        bd_th_daishuceng3_1 = (EditText) findViewById(R.id.bd_th_daishuceng3_1);
        bd_th_daishuceng3_2 = (EditText) findViewById(R.id.bd_th_daishuceng3_2);
        bd_th_daishuceng3_3 = (Spinner) findViewById(R.id.bd_th_daishuceng3_3);

        bd_th_daishuceng4_1 = (EditText) findViewById(R.id.bd_th_daishuceng4_1);
        bd_th_daishuceng4_2 = (EditText) findViewById(R.id.bd_th_daishuceng4_2);
        bd_th_daishuceng4_3 = (Spinner) findViewById(R.id.bd_th_daishuceng4_3);

        bd_th_taitigunya = (EditText) findViewById(R.id.bd_th_taitigunya);
        bd_th_taipeizhouchang = (EditText) findViewById(R.id.bd_th_taipeizhouchang);
        //默认参数设置
        /*bd_th_taice1.setText("ceshi");
        bd_th_taice2.setText("ceshi");
        bd_th_neichenceng1.setText("ceshi");
        bd_th_neichenceng2.setText("ceshi");
        bd_th_gangbaoTH1.setText("ceshi");
        bd_th_gangbaoTH2.setText("ceshi");
        bd_th_taiti1.setText("ceshi");
        bd_th_taiti2.setText("ceshi");
        bd_th_dianjiaoTH1.setText("ceshi");
        bd_th_dianjiaoTH2.setText("ceshi");
        bd_th_daishuceng1_1.setText("ceshi");
        bd_th_daishuceng1_2.setText("ceshi");
        bd_th_daishuceng2_1.setText("ceshi");
        bd_th_daishuceng2_2.setText("ceshi");
        bd_th_daishuceng3_1.setText("ceshi");
        bd_th_daishuceng3_2.setText("ceshi");
        bd_th_daishuceng4_1.setText("ceshi");
        bd_th_daishuceng4_2.setText("ceshi");*/

        /**
         * btn*_*
         *
         */
        Button btn1_1 = (Button) findViewById(R.id.btn1_1);
        Button btn1_2 = (Button) findViewById(R.id.btn1_2);
        Button btn1_3 = (Button) findViewById(R.id.btn1_3);
        Button btn1_4 = (Button) findViewById(R.id.btn1_4);
        Button btn1_5 = (Button) findViewById(R.id.btn1_5);

        Button btn2_1 = (Button) findViewById(R.id.btn2_1);
        Button btn2_2 = (Button) findViewById(R.id.btn2_2);
        Button btn2_3 = (Button) findViewById(R.id.btn2_3);
        Button btn2_4 = (Button) findViewById(R.id.btn2_4);
        Button btn2_5 = (Button) findViewById(R.id.btn2_5);
        Button btn2_6 = (Button) findViewById(R.id.btn2_6);
        Button btn2_7 = (Button) findViewById(R.id.btn2_7);
        Button btn2_8 = (Button) findViewById(R.id.btn2_8);
        Button btn2_9 = (Button) findViewById(R.id.btn2_9);
        Button btn2_10 = (Button) findViewById(R.id.btn2_10);
        Button btn2_11 = (Button) findViewById(R.id.btn2_11);

        Button btn3_1 = (Button) findViewById(R.id.btn3_1);
        Button btn3_2 = (Button) findViewById(R.id.btn3_2);
        Button btn3_3 = (Button) findViewById(R.id.btn3_3);
        Button btn3_4 = (Button) findViewById(R.id.btn3_4);
        Button btn3_5 = (Button) findViewById(R.id.btn3_5);
        Button btn3_6 = (Button) findViewById(R.id.btn3_6);
        Button btn3_7 = (Button) findViewById(R.id.btn3_7);
        Button btn3_8 = (Button) findViewById(R.id.btn3_8);
        Button btn3_9 = (Button) findViewById(R.id.btn3_9);
        Button btn3_10 = (Button) findViewById(R.id.btn3_10);
        Button btn3_11 = (Button) findViewById(R.id.btn3_11);
        /**
         *按钮点击事件
         */
        btn1_1.setOnClickListener(this);
        btn1_2.setOnClickListener(this);
        btn1_3.setOnClickListener(this);
        btn1_4.setOnClickListener(this);
        btn1_5.setOnClickListener(this);

        btn2_1.setOnClickListener(this);
        btn2_2.setOnClickListener(this);
        btn2_3.setOnClickListener(this);
        btn2_4.setOnClickListener(this);
        btn2_5.setOnClickListener(this);
        btn2_6.setOnClickListener(this);
        btn2_7.setOnClickListener(this);
        btn2_8.setOnClickListener(this);
        btn2_9.setOnClickListener(this);
        btn2_10.setOnClickListener(this);
        btn2_11.setOnClickListener(this);

        btn3_1.setOnClickListener(this);
        btn3_2.setOnClickListener(this);
        btn3_3.setOnClickListener(this);
        btn3_4.setOnClickListener(this);
        btn3_5.setOnClickListener(this);
        btn3_6.setOnClickListener(this);
        btn3_7.setOnClickListener(this);
        btn3_8.setOnClickListener(this);
        btn3_9.setOnClickListener(this);
        btn3_10.setOnClickListener(this);
        btn3_11.setOnClickListener(this);
        /**
         * spinner 初始化
         *
         */
        bd_th_bzpwaiguan = (Spinner) findViewById(R.id.bd_th_bzpwaiguan);
        bd_th_dingweijiaodu = (Spinner) findViewById(R.id.bd_th_dingweijiaodu);
        bd_th_taimian = (Spinner) findViewById(R.id.bd_th_taimian);
        bd_th_xianyong = (Spinner) findViewById(R.id.bd_th_xianyong);
        bd_th_sanxian = (Spinner) findViewById(R.id.bd_th_sanxian);
        bd_biaozhunshuju = (Button) findViewById(R.id.bd_biaozhunshuju);
        bd_biaozhunshuju.setOnClickListener(this);
        initSPinner();
    }

    /**
     * 获取每个下拉框的数据
     */
    private void initSPinner() {
        ArrayAdapter<String> bzpwaiguan_Adapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style, R.id.txtvwSpinner, SP_TYPE);
        bzpwaiguan_Adapter.setDropDownViewResource(R.layout.spinner_dropdown_style);
        bd_th_bzpwaiguan.setAdapter(bzpwaiguan_Adapter);
        bd_th_bzpwaiguan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spr_waiguan = String.valueOf(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> dingweijiaodu_Adapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style, R.id.txtvwSpinner, SP_TYPE);
        dingweijiaodu_Adapter.setDropDownViewResource(R.layout.spinner_dropdown_style);
        bd_th_dingweijiaodu.setAdapter(dingweijiaodu_Adapter);
        bd_th_dingweijiaodu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spr_jiaodu = String.valueOf(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> taimian_Adapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style, R.id.txtvwSpinner, SP_TYPE);
        taimian_Adapter.setDropDownViewResource(R.layout.spinner_dropdown_style);
        bd_th_taimian.setAdapter(taimian_Adapter);
        bd_th_taimian.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spr_taimian = String.valueOf(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> xianyong_Adapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style, R.id.txtvwSpinner, SP_TYPE);
        xianyong_Adapter.setDropDownViewResource(R.layout.spinner_dropdown_style);
        bd_th_xianyong.setAdapter(xianyong_Adapter);
        bd_th_xianyong.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spr_xianyong = String.valueOf(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> sanxian_Adapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style, R.id.txtvwSpinner, SP_TYPE);
        sanxian_Adapter.setDropDownViewResource(R.layout.spinner_dropdown_style);
        bd_th_sanxian.setAdapter(sanxian_Adapter);
        bd_th_sanxian.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spr_sanxian = String.valueOf(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /**
         * taice
         */
        ArrayAdapter<String> taice_Adapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style, R.id.txtvwSpinner, SP_TYPE);
        taice_Adapter.setDropDownViewResource(R.layout.spinner_dropdown_style);
        bd_th_taice3.setAdapter(taice_Adapter);
        bd_th_taice3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spr_taice3 = String.valueOf(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> neicengceng_Adapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style, R.id.txtvwSpinner, SP_TYPE);
        neicengceng_Adapter.setDropDownViewResource(R.layout.spinner_dropdown_style);
        bd_th_neichenceng3.setAdapter(neicengceng_Adapter);
        bd_th_neichenceng3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spr_neichenceng3 = String.valueOf(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> gangbaoTH_Adapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style, R.id.txtvwSpinner, SP_TYPE);
        gangbaoTH_Adapter.setDropDownViewResource(R.layout.spinner_dropdown_style);
        bd_th_gangbaoTH3.setAdapter(gangbaoTH_Adapter);
        bd_th_gangbaoTH3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spr_gangbaoTH3 = String.valueOf(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> taiti_Adapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style, R.id.txtvwSpinner, SP_TYPE);
        taiti_Adapter.setDropDownViewResource(R.layout.spinner_dropdown_style);
        bd_th_taiti3.setAdapter(taiti_Adapter);
        bd_th_taiti3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spr_taiti3 = String.valueOf(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> dianjiaoTH_Adapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style, R.id.txtvwSpinner, SP_TYPE);
        dianjiaoTH_Adapter.setDropDownViewResource(R.layout.spinner_dropdown_style);
        bd_th_dianjiaoTH3.setAdapter(dianjiaoTH_Adapter);
        bd_th_dianjiaoTH3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spr_dianjiaoTH3 = String.valueOf(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> daishuceng1_Adapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style, R.id.txtvwSpinner, SP_TYPE);
        daishuceng1_Adapter.setDropDownViewResource(R.layout.spinner_dropdown_style);
        bd_th_daishuceng1_3.setAdapter(daishuceng1_Adapter);
        bd_th_daishuceng1_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spr_daishuceng1_3 = String.valueOf(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> daishuceng2_Adapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style, R.id.txtvwSpinner, SP_TYPE);
        daishuceng2_Adapter.setDropDownViewResource(R.layout.spinner_dropdown_style);
        bd_th_daishuceng2_3.setAdapter(daishuceng2_Adapter);
        bd_th_daishuceng2_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spr_daishuceng2_3 = String.valueOf(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> daishuceng3_Adapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style, R.id.txtvwSpinner, SP_TYPE);
        daishuceng3_Adapter.setDropDownViewResource(R.layout.spinner_dropdown_style);
        bd_th_daishuceng3_3.setAdapter(daishuceng3_Adapter);
        bd_th_daishuceng3_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spr_daishuceng3_3 = String.valueOf(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> daishuceng4_Adapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style, R.id.txtvwSpinner, SP_TYPE);
        daishuceng4_Adapter.setDropDownViewResource(R.layout.spinner_dropdown_style);
        bd_th_daishuceng4_3.setAdapter(daishuceng4_Adapter);
        bd_th_daishuceng4_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spr_daishuceng4_3 = String.valueOf(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    /**
     * 获取每个editext的输入数据
     */
    private void initData() {
        /**
         * bujianchanshu
         */
        bj_taice1 = bd_bj_taice1.getText().toString();
        bj_taice2 = bd_bj_taice2.getText().toString();
        bj_taice3 = bd_bj_taice3.getText().toString();
        bj_taice4 = bd_bj_taice4.getText().toString();

        bj_neichenceng1 = bd_bj_neichenceng1.getText().toString();
        bj_neichenceng2 = bd_bj_neichenceng2.getText().toString();
        bj_neichenceng3 = bd_bj_neichenceng3.getText().toString();
        bj_neichenceng4 = bd_bj_neichenceng4.getText().toString();

        bj_gangbao1 = bd_bj_gangbao1.getText().toString();
        bj_gangbao2 = bd_bj_gangbao2.getText().toString();
        bj_gangbao3 = bd_bj_gangbao3.getText().toString();
        bj_gangbao4 = bd_bj_gangbao4.getText().toString();

        bj_taiti1 = bd_bj_taiti1.getText().toString();
        bj_taiti2 = bd_bj_taiti2.getText().toString();
        bj_taiti3 = bd_bj_taiti3.getText().toString();
        bj_taiti4 = bd_bj_taiti4.getText().toString();

        bj_dianjiao1 = bd_bj_dianjiao1.getText().toString();
        bj_dianjiao2 = bd_bj_dianjiao2.getText().toString();
        bj_dianjiao3 = bd_bj_dianjiao3.getText().toString();
        bj_dianjiao4 = bd_bj_dianjiao4.getText().toString();

        bj_daishuceng1_1 = bd_bj_daishuceng1_1.getText().toString();
        bj_daishuceng1_2 = bd_bj_daishuceng1_2.getText().toString();
        bj_daishuceng1_3 = bd_bj_daishuceng1_3.getText().toString();
        bj_daishuceng1_4 = bd_bj_daishuceng1_4.getText().toString();

        bj_daishuceng2_1 = bd_bj_daishuceng2_1.getText().toString();
        bj_daishuceng2_2 = bd_bj_daishuceng2_2.getText().toString();
        bj_daishuceng2_3 = bd_bj_daishuceng2_3.getText().toString();
        bj_daishuceng2_4 = bd_bj_daishuceng2_4.getText().toString();

        bj_daishuceng3_1 = bd_bj_daishuceng3_1.getText().toString();
        bj_daishuceng3_2 = bd_bj_daishuceng3_2.getText().toString();
        bj_daishuceng3_3 = bd_bj_daishuceng3_3.getText().toString();
        bj_daishuceng3_4 = bd_bj_daishuceng3_4.getText().toString();

        bj_daishuceng4_1 = bd_bj_daishuceng4_1.getText().toString();
        bj_daishuceng4_2 = bd_bj_daishuceng4_2.getText().toString();
        bj_daishuceng4_3 = bd_bj_daishuceng4_3.getText().toString();
        bj_daishuceng4_4 = bd_bj_daishuceng4_4.getText().toString();

        bj_taimian1 = bd_bj_taimian1.getText().toString();
        bj_taimian2 = bd_bj_taimian2.getText().toString();
        bj_taimian3 = bd_bj_taimian3.getText().toString();
        bj_taimian4 = bd_bj_taimian4.getText().toString();

        bj_zhugu = bd_bj_zhugu.getText().toString();
        bj_fugu = bd_bj_fugu.getText().toString();
        /**
         * tieheweizhi
         *
         */
        th_taice1 = bd_th_taice1.getText().toString();
        th_taice2 = bd_th_taice2.getText().toString();


        th_neichenceng1 = bd_th_neichenceng1.getText().toString();
        th_neichenceng2 = bd_th_neichenceng2.getText().toString();


        th_gangbaoTH1 = bd_th_gangbaoTH1.getText().toString();
        th_gangbaoTH2 = bd_th_gangbaoTH2.getText().toString();


        th_taiti1 = bd_th_taiti1.getText().toString();
        th_taiti2 = bd_th_taiti2.getText().toString();


        th_dianjiaoTH1 = bd_th_dianjiaoTH1.getText().toString();
        th_dianjiaoTH2 = bd_th_dianjiaoTH2.getText().toString();


        th_daishuceng1_1 = bd_th_daishuceng1_1.getText().toString();
        th_daishuceng1_2 = bd_th_daishuceng1_2.getText().toString();


        th_daishuceng2_1 = bd_th_daishuceng2_1.getText().toString();
        th_daishuceng2_2 = bd_th_daishuceng2_2.getText().toString();


        th_daishuceng3_1 = bd_th_daishuceng3_1.getText().toString();
        th_daishuceng3_2 = bd_th_daishuceng3_2.getText().toString();


        th_daishuceng4_1 = bd_th_daishuceng4_1.getText().toString();
        th_daishuceng4_2 = bd_th_daishuceng4_2.getText().toString();


    }

    /**
     * 网络请求，点一次按钮请求一次
     */
    public void getDataFromServer() {
        if (cm1.isEmpty()) {
            new AlertDialog.Builder(this).setTitle("提交错误").setMessage("提交数据不能为空")
                    .setPositiveButton("确定", null).show();

        } else {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiConstants.OUTER_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ApiService apiService = retrofit.create(ApiService.class);
            // http://171.188.42.56:8081/app/API/WorkManage/GetQualityDataInfo?qdiymd=20170912&qdishift=1&qdicrew=1&qdimachineid=F07&qdisizeid=12R22.5&qdipr=16PR&qdipattern=AZ565&qdibrand=&qdisale=%E6%9C%9D%E7%B3%BB&qditypeid=1&qdidataid=1&qdip1=10&qdip2=20&qdip3=30&qdip4=50
            apiService.getTijiaoshuju(riqi, bc, bz, jt, guige, cengji, huawen, "", xilie, typeCode, dateCode, cm1, cm2, cm3, cm4).enqueue(new Callback<tijiaoBean>() {
                @Override
                public void onResponse(Call<tijiaoBean> call, Response<tijiaoBean> response) {
                    if (response.body() != null) {
                        String result = response.body().getResult();
                        if (result.equals("1")) {
                            Toast.makeText(getApplicationContext(), "录入成功...", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "1-1录入失败...", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<tijiaoBean> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "网络连接失败...", Toast.LENGTH_SHORT).show();
                }
            });
        }


    }


    /**
     * 2网络请求，点一次按钮请求一次
     */
    public void getDataFromServer2() {
        if (cm1_2.isEmpty()) {
            return;
        } else {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiConstants.OUTER_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ApiService apiService2 = retrofit.create(ApiService.class);
            // http://171.188.42.56:8081/app/API/WorkManage/GetQualityDataInfo?qdiymd=20170912&qdishift=1&qdicrew=1&qdimachineid=F07&qdisizeid=12R22.5&qdipr=16PR&qdipattern=AZ565&qdibrand=&qdisale=%E6%9C%9D%E7%B3%BB&qditypeid=1&qdidataid=1&qdip1=10&qdip2=20&qdip3=30&qdip4=50
            apiService2.getTijiaoshuju(riqi, bc, bz, jt, guige, cengji, huawen, "", xilie, typeCode, dateCode, cm1_2, "", "", "").enqueue(new Callback<tijiaoBean>() {
                @Override
                public void onResponse(Call<tijiaoBean> call, Response<tijiaoBean> response) {
                    if (response.body() != null) {
                        String result = response.body().getResult();
                        if (result.equals("1")) {
                            Toast.makeText(getApplicationContext(), "录入成功...", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "1-2录入失败...", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<tijiaoBean> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "网络连接失败...", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    /**
     * 3网络请求，点一次按钮请求一次
     */
    public void getDataFromServer3() {
        if (cm1_3.isEmpty()) {
            return;

        } else {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiConstants.OUTER_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ApiService apiService3 = retrofit.create(ApiService.class);
            // http://171.188.42.56:8081/app/API/WorkManage/GetQualityDataInfo?qdiymd=20170912&qdishift=1&qdicrew=1&qdimachineid=F07&qdisizeid=12R22.5&qdipr=16PR&qdipattern=AZ565&qdibrand=&qdisale=%E6%9C%9D%E7%B3%BB&qditypeid=1&qdidataid=1&qdip1=10&qdip2=20&qdip3=30&qdip4=50
            apiService3.getTijiaoshuju(riqi, bc, bz, jt, guige, cengji, huawen, "", xilie, typeCode, dateCode, cm1_3, "", "", "").enqueue(new Callback<tijiaoBean>() {
                @Override
                public void onResponse(Call<tijiaoBean> call, Response<tijiaoBean> response) {
                    if (response.body() != null) {
                        String result = response.body().getResult();
                        if (result.equals("1")) {
                            Toast.makeText(getApplicationContext(), "录入成功...", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "1-3录入失败...", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<tijiaoBean> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "网络连接失败...", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    /**
     * 3网络请求，点一次按钮请求一次
     */
    public void getDataFromServer4() {
        if (cm1_4.isEmpty()) {
            return;

        } else {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiConstants.OUTER_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ApiService apiService4 = retrofit.create(ApiService.class);
            // http://171.188.42.56:8081/app/API/WorkManage/GetQualityDataInfo?qdiymd=20170912&qdishift=1&qdicrew=1&qdimachineid=F07&qdisizeid=12R22.5&qdipr=16PR&qdipattern=AZ565&qdibrand=&qdisale=%E6%9C%9D%E7%B3%BB&qditypeid=1&qdidataid=1&qdip1=10&qdip2=20&qdip3=30&qdip4=50

            apiService4.getTijiaoshuju(riqi, bc, bz, jt, guige, cengji, huawen, "", xilie, typeCode, dateCode, cm1_4, "", "", "").enqueue(new Callback<tijiaoBean>() {
                @Override
                public void onResponse(Call<tijiaoBean> call, Response<tijiaoBean> response) {
                    if (response.body() != null) {
                        String result = response.body().getResult();
                        if (result.equals("1")) {
                            Toast.makeText(getApplicationContext(), "录入成功...", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "1-4录入失败...", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<tijiaoBean> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "网络连接失败...", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    public void getDataFromServer5() {
        if (cm1.isEmpty()) {
            new AlertDialog.Builder(this).setTitle("提交警告").setMessage("确认提交数据为空吗？")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Retrofit retrofit = new Retrofit.Builder()
                                    .baseUrl(ApiConstants.OUTER_URL)
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build();
                            ApiService apiService = retrofit.create(ApiService.class);
                            // http://171.188.42.56:8081/app/API/WorkManage/GetQualityDataInfo?qdiymd=20170912&qdishift=1&qdicrew=1&qdimachineid=F07&qdisizeid=12R22.5&qdipr=16PR&qdipattern=AZ565&qdibrand=&qdisale=%E6%9C%9D%E7%B3%BB&qditypeid=1&qdidataid=1&qdip1=10&qdip2=20&qdip3=30&qdip4=50
                            apiService.getTijiaoshuju(riqi, bc, bz, jt, guige, cengji, huawen, "", xilie, typeCode, dateCode, cm1, cm2, cm3, cm4).enqueue(new Callback<tijiaoBean>() {
                                @Override
                                public void onResponse(Call<tijiaoBean> call, Response<tijiaoBean> response) {
                                    if (response.body() != null) {
                                        String result = response.body().getResult();
                                        if (result.equals("1")) {
                                            Toast.makeText(getApplicationContext(), "录入成功...", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(getApplicationContext(), "1-1录入失败...", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }

                                @Override
                                public void onFailure(Call<tijiaoBean> call, Throwable t) {
                                    Toast.makeText(getApplicationContext(), "网络连接失败...", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "取消发送...", Toast.LENGTH_SHORT).show();
                    return;

                }
            }).show();

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1_1:
                typeCode = "1";
                dateCode = "1";
                cx_pingmian1 = bd_cx_pingmian1.getText().toString();
                cx_pingmian2 = bd_cx_pingmian2.getText().toString();
                cx_pingmian3 = bd_cx_pingmian3.getText().toString();
                cx_pingmian4 = bd_cx_pingmian4.getText().toString();
                cm1 = cx_pingmian1;
                cm2 = cx_pingmian2;
                cm3 = cx_pingmian3;
                cm4 = cx_pingmian4;
                getDataFromServer();
                break;

            case R.id.btn1_2:
                typeCode = "1";
                dateCode = "2";
                cx_gangsiquan1 = bd_cx_gangsiquan1.getText().toString();
                cx_gangsiquan2 = bd_cx_gangsiquan2.getText().toString();
                cx_gangsiquan3 = bd_cx_gangsiquan3.getText().toString();
                cx_gangsiquan4 = bd_cx_gangsiquan4.getText().toString();
                cm1 = cx_gangsiquan1;
                cm2 = cx_gangsiquan2;
                cm3 = cx_gangsiquan3;
                cm4 = cx_gangsiquan4;
                getDataFromServer();
                break;
            case R.id.btn1_3:
                typeCode = "1";
                dateCode = "3";
                cx_chengqi1 = bd_cx_chengqi1.getText().toString();
                cx_chengqi2 = bd_cx_chengqi2.getText().toString();
                cx_chengqi3 = bd_cx_chengqi3.getText().toString();
                cx_chengqi4 = bd_cx_chengqi4.getText().toString();
                cm1 = cx_chengqi1;
                cm2 = cx_chengqi2;
                cm3 = cx_chengqi3;
                cm4 = cx_chengqi4;
                getDataFromServer();
                break;
            case R.id.btn1_4:
                typeCode = "1";
                dateCode = "4";
                cx_yudingxing = bd_cx_yudingxing.getText().toString();
                cm1 = cx_yudingxing;
                cm2 = "";
                cm3 = "";
                cm4 = "";
                getDataFromServer();
                dateCode = "5";
                cx_dingxing = bd_cx_dingxing.getText().toString();
                cm1_2 = cx_dingxing;
                getDataFromServer2();
                break;
            case R.id.btn1_5:
                typeCode = "1";
                dateCode = "6";
                cx_chaodingxing = bd_cx_chaodingxing.getText().toString();
                cm1 = cx_chaodingxing;
                cm2 = "";
                cm3 = "";
                cm4 = "";
                getDataFromServer();
                dateCode = "7";
                cx_daishugu = bd_cx_daishugu.getText().toString();
                cm1_2 = cx_daishugu;
                getDataFromServer2();
                dateCode = "8";
                cx_tiehegu = bd_cx_tiehegu.getText().toString();
                cm1_3 = cx_tiehegu;
                getDataFromServer3();

                break;
            case R.id.btn2_1:
                bj_taice1 = bd_bj_taice1.getText().toString();
                bj_taice2 = bd_bj_taice2.getText().toString();
                bj_taice3 = bd_bj_taice3.getText().toString();
                bj_taice4 = bd_bj_taice4.getText().toString();
                typeCode = "2";
                dateCode = "1";
                cm1 = bj_taice1;
                cm2 = bj_taice2;
                cm3 = bj_taice3;
                cm4 = bj_taice4;
                getDataFromServer();
                break;
            case R.id.btn2_2:
                bj_neichenceng1 = bd_bj_neichenceng1.getText().toString();
                bj_neichenceng2 = bd_bj_neichenceng2.getText().toString();
                bj_neichenceng3 = bd_bj_neichenceng3.getText().toString();
                bj_neichenceng4 = bd_bj_neichenceng4.getText().toString();

                cm1 = bj_neichenceng1;
                cm2 = bj_neichenceng2;
                cm3 = bj_neichenceng3;
                cm4 = bj_neichenceng4;
                typeCode = "2";
                dateCode = "2";
                getDataFromServer();
                break;
            case R.id.btn2_3:

                bj_gangbao1 = bd_bj_gangbao1.getText().toString();
                bj_gangbao2 = bd_bj_gangbao2.getText().toString();
                bj_gangbao3 = bd_bj_gangbao3.getText().toString();
                bj_gangbao4 = bd_bj_gangbao4.getText().toString();

                cm1 = bj_gangbao1;
                cm2 = bj_gangbao2;
                cm3 = bj_gangbao3;
                cm4 = bj_gangbao4;
                typeCode = "2";
                dateCode = "3";
                getDataFromServer();
                break;
            case R.id.btn2_4:
                bj_taiti1 = bd_bj_taiti1.getText().toString();
                bj_taiti2 = bd_bj_taiti2.getText().toString();
                bj_taiti3 = bd_bj_taiti3.getText().toString();
                bj_taiti4 = bd_bj_taiti4.getText().toString();

                cm1 = bj_taiti1;
                cm2 = bj_taiti2;
                cm3 = bj_taiti3;
                cm4 = bj_taiti4;
                typeCode = "2";
                dateCode = "4";
                getDataFromServer();
                break;
            case R.id.btn2_5:
                typeCode = "2";
                dateCode = "5";
                bj_dianjiao1 = bd_bj_dianjiao1.getText().toString();
                bj_dianjiao2 = bd_bj_dianjiao2.getText().toString();
                bj_dianjiao3 = bd_bj_dianjiao3.getText().toString();
                bj_dianjiao4 = bd_bj_dianjiao4.getText().toString();

                cm1 = bj_dianjiao1;
                cm2 = bj_dianjiao2;
                cm3 = bj_dianjiao3;
                cm4 = bj_dianjiao4;
                getDataFromServer();
                break;
            case R.id.btn2_6:
                bj_daishuceng1_1 = bd_bj_daishuceng1_1.getText().toString();
                bj_daishuceng1_2 = bd_bj_daishuceng1_2.getText().toString();
                bj_daishuceng1_3 = bd_bj_daishuceng1_3.getText().toString();
                bj_daishuceng1_4 = bd_bj_daishuceng1_4.getText().toString();
                cm1 = bj_daishuceng1_1;
                cm2 = bj_daishuceng1_2;
                cm3 = bj_daishuceng1_3;
                cm4 = bj_daishuceng1_4;
                typeCode = "2";
                dateCode = "6";
                getDataFromServer();
                break;
            case R.id.btn2_7:
                bj_daishuceng2_1 = bd_bj_daishuceng2_1.getText().toString();
                bj_daishuceng2_2 = bd_bj_daishuceng2_2.getText().toString();
                bj_daishuceng2_3 = bd_bj_daishuceng2_3.getText().toString();
                bj_daishuceng2_4 = bd_bj_daishuceng2_4.getText().toString();

                cm1 = bj_daishuceng2_1;
                cm2 = bj_daishuceng2_2;
                cm3 = bj_daishuceng2_3;
                cm4 = bj_daishuceng2_4;
                typeCode = "2";
                dateCode = "7";
                getDataFromServer();
                break;
            case R.id.btn2_8:
                bj_daishuceng3_1 = bd_bj_daishuceng3_1.getText().toString();
                bj_daishuceng3_2 = bd_bj_daishuceng3_2.getText().toString();
                bj_daishuceng3_3 = bd_bj_daishuceng3_3.getText().toString();
                bj_daishuceng3_4 = bd_bj_daishuceng3_4.getText().toString();

                cm1 = bj_daishuceng3_1;
                cm2 = bj_daishuceng3_2;
                cm3 = bj_daishuceng3_3;
                cm4 = bj_daishuceng3_4;
                typeCode = "2";
                dateCode = "8";
                getDataFromServer();
                break;
            case R.id.btn2_9:
                bj_daishuceng4_1 = bd_bj_daishuceng4_1.getText().toString();
                bj_daishuceng4_2 = bd_bj_daishuceng4_2.getText().toString();
                bj_daishuceng4_3 = bd_bj_daishuceng4_3.getText().toString();
                bj_daishuceng4_4 = bd_bj_daishuceng4_4.getText().toString();
                cm1 = bj_daishuceng4_1;
                cm2 = bj_daishuceng4_2;
                cm3 = bj_daishuceng4_3;
                cm4 = bj_daishuceng4_4;
                typeCode = "2";
                dateCode = "9";
                getDataFromServer5();
                break;
            case R.id.btn2_10:
                bj_taimian1 = bd_bj_taimian1.getText().toString();
                bj_taimian2 = bd_bj_taimian2.getText().toString();
                bj_taimian3 = bd_bj_taimian3.getText().toString();
                bj_taimian4 = bd_bj_taimian4.getText().toString();

                typeCode = "2";
                dateCode = "10";
                cm1 = bj_taimian1;
                cm2 = bj_taimian2;
                cm3 = "";
                cm4 = "";
                getDataFromServer();
                break;
            case R.id.btn2_11:
                bj_zhugu = bd_bj_zhugu.getText().toString();
                typeCode = "2";
                dateCode = "11";
                cm1 = bj_zhugu;
                cm2 = "";
                cm3 = "";
                cm4 = "";
                getDataFromServer();
                dateCode = "12";
                bj_fugu = bd_bj_fugu.getText().toString();
                cm1_2 = bj_fugu;
                getDataFromServer2();
                break;

            case R.id.btn3_10:
                typeCode = "3";
                dateCode = "14";
                String th_taitigunya = bd_th_taitigunya.getText().toString();
                cm1 = th_taitigunya;
                cm2 = "";
                cm3 = "";
                cm4 = "";
                getDataFromServer();

                dateCode = "15";
                String th_taipeizhouchang = bd_th_taipeizhouchang.getText().toString();
                cm1_2 = th_taipeizhouchang;
                getDataFromServer2();

                dateCode = "1";
                cm1_3 = spr_waiguan;
                getDataFromServer3();
                break;
            case R.id.btn3_11:
                typeCode = "3";
                dateCode = "3";
                cm1 = spr_jiaodu;
                cm2 = "";
                cm3 = "";
                cm4 = "";
                getDataFromServer();
                dateCode = "13";
                cm1_2 = spr_taimian;
                getDataFromServer2();
                dateCode = "16";
                cm1_3 = spr_xianyong;
                getDataFromServer3();
                dateCode = "17";
                cm1_4 = spr_sanxian;
                getDataFromServer4();
                break;
            case R.id.btn3_1:
                typeCode = "3";
                dateCode = "4";
                th_taice1 = bd_th_taice1.getText().toString();
                th_taice2 = bd_th_taice2.getText().toString();
                cm1 = th_taice1;
                cm2 = th_taice2;
                cm3 = spr_taice3;
                cm4 = "";
                getDataFromServer();
                break;
            case R.id.btn3_2:
                typeCode = "3";
                dateCode = "5";
                th_neichenceng1 = bd_th_neichenceng1.getText().toString();
                th_neichenceng2 = bd_th_neichenceng2.getText().toString();
                cm1 = th_neichenceng1;
                cm2 = th_neichenceng2;
                cm3 = spr_neichenceng3;
                cm4 = "";
                getDataFromServer();
                break;
            case R.id.btn3_3:
                typeCode = "3";
                dateCode = "6";
                th_gangbaoTH1 = bd_th_gangbaoTH1.getText().toString();
                th_gangbaoTH2 = bd_th_gangbaoTH2.getText().toString();
                cm1 = th_gangbaoTH1;
                cm2 = th_gangbaoTH2;
                cm3 = spr_gangbaoTH3;
                cm4 = "";
                getDataFromServer();


                break;
            case R.id.btn3_4:
                typeCode = "3";
                dateCode = "7";
                th_taiti1 = bd_th_taiti1.getText().toString();
                th_taiti2 = bd_th_taiti2.getText().toString();
                cm1 = th_taiti1;
                cm2 = th_taiti2;
                cm3 = spr_taiti3;
                cm4 = "";
                getDataFromServer();

                break;
            case R.id.btn3_5:
                typeCode = "3";
                dateCode = "8";
                th_dianjiaoTH1 = bd_th_dianjiaoTH1.getText().toString();
                th_dianjiaoTH2 = bd_th_dianjiaoTH2.getText().toString();
                cm1 = th_dianjiaoTH1;
                cm2 = th_dianjiaoTH2;
                cm3 = spr_dianjiaoTH3;
                cm4 = "";
                getDataFromServer();
                break;

            case R.id.btn3_6:
                typeCode = "3";
                dateCode = "9";
                th_daishuceng1_1 = bd_th_daishuceng1_1.getText().toString();
                th_daishuceng1_2 = bd_th_daishuceng1_2.getText().toString();
                cm1 = th_daishuceng1_1;
                cm2 = th_daishuceng1_2;
                cm3 = spr_daishuceng1_3;
                cm4 = "";
                getDataFromServer();

                break;
            case R.id.btn3_7:
                typeCode = "3";
                dateCode = "10";
                th_daishuceng2_1 = bd_th_daishuceng2_1.getText().toString();
                th_daishuceng2_2 = bd_th_daishuceng2_2.getText().toString();
                cm1 = th_daishuceng2_1;
                cm2 = th_daishuceng2_2;
                cm3 = spr_daishuceng2_3;
                cm4 = "";
                getDataFromServer();

                break;
            case R.id.btn3_8:
                typeCode = "3";
                dateCode = "11";
                th_daishuceng3_1 = bd_th_daishuceng3_1.getText().toString();
                th_daishuceng3_2 = bd_th_daishuceng3_2.getText().toString();
                cm1 = th_daishuceng3_1;
                cm2 = th_daishuceng3_2;
                cm3 = spr_daishuceng3_3;
                cm4 = "";
                getDataFromServer();

                break;
            case R.id.btn3_9:
                typeCode = "3";
                dateCode = "12";
                th_daishuceng4_1 = bd_th_daishuceng4_1.getText().toString();
                th_daishuceng4_2 = bd_th_daishuceng4_2.getText().toString();
                cm1 = th_daishuceng4_1;
                cm2 = th_daishuceng4_2;
                cm3 = spr_daishuceng4_3;
                cm4 = "";
                getDataFromServer5();
                break;
            case R.id.bd_biaozhunshuju:
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("guige", guige);
                bundle.putString("cengji", cengji);
                bundle.putString("huawen", huawen);
                bundle.putString("xilie", xilie);
                bundle.putString("processno", processno);
                intent.putExtras(bundle);
                intent.setClass(getApplicationContext(), standardataActivity.class);
                startActivity(intent);
                break;
        }
    }


}

