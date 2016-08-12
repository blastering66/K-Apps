package com.kufed.id.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.kufed.id.customview.KufedSpinner;
import com.kufed.id.customview.KufedTextView;
import com.kufed.id.customview.KufedTextViewTitle;
import com.kufed.id.fragment.Fragment_Checkout_Payment;
import com.kufed.id.fragment.Fragment_Checkout_Review;
import com.kufed.id.fragment.Fragment_Checkout_Shipping;
import com.kufed.id.pojo.PojoCheckoutFee;
import com.kufed.id.pojo.PojoCheckoutGet;
import com.kufed.id.pojo.PojoCheckoutSubmit;
import com.kufed.id.pojo.PojoResponseAddressList;
import com.kufed.id.pojo.PojoResponseVeritrans;
import com.kufed.id.rest.Rest_Adapter;
import com.kufed.id.rowdata.Rowdata_Address;
import com.kufed.id.rowdata.Rowdata_PaymentMethod;
import com.kufed.id.util.Param_Collection;
import com.kufed.id.util.Public_Functions;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import org.greenrobot.eventbus.Subscribe;

import id.co.veritrans.android.api.VTDirect;
import id.co.veritrans.android.api.VTInterface.ITokenCallback;
import id.co.veritrans.android.api.VTModel.VTCardDetails;
import id.co.veritrans.android.api.VTModel.VTToken;
import id.co.veritrans.android.api.VTUtil.VTConfig;
import id.co.veritrans.sdk.coreflow.*;
import id.co.veritrans.sdk.coreflow.core.SdkCoreFlowBuilder;
import id.co.veritrans.sdk.coreflow.core.TransactionRequest;
import id.co.veritrans.sdk.coreflow.core.VeritransSDK;
import id.co.veritrans.sdk.coreflow.eventbus.bus.VeritransBusProvider;
import id.co.veritrans.sdk.coreflow.eventbus.callback.TokenBusCallback;
import id.co.veritrans.sdk.coreflow.eventbus.callback.TransactionBusCallback;
import id.co.veritrans.sdk.coreflow.eventbus.events.GeneralErrorEvent;
import id.co.veritrans.sdk.coreflow.eventbus.events.GetTokenFailedEvent;
import id.co.veritrans.sdk.coreflow.eventbus.events.GetTokenSuccessEvent;
import id.co.veritrans.sdk.coreflow.eventbus.events.NetworkUnavailableEvent;
import id.co.veritrans.sdk.coreflow.eventbus.events.TransactionFailedEvent;
import id.co.veritrans.sdk.coreflow.eventbus.events.TransactionSuccessEvent;
import id.co.veritrans.sdk.coreflow.models.BillingAddress;
import id.co.veritrans.sdk.coreflow.models.CardPaymentDetails;
import id.co.veritrans.sdk.coreflow.models.CardTokenRequest;
import id.co.veritrans.sdk.coreflow.models.CardTransfer;
import id.co.veritrans.sdk.coreflow.models.CustomerDetails;
import id.co.veritrans.sdk.coreflow.models.ItemDetails;
import id.co.veritrans.sdk.coreflow.models.PaymentMethodsModel;
import id.co.veritrans.sdk.coreflow.models.ShippingAddress;
//import id.co.veritrans.sdk.coreflow.models.TransactionDetails;
import id.co.veritrans.sdk.coreflow.models.TransactionDetails;
import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by macbook on 8/3/16.
 */
public class Checkout_OnePage extends AppCompatActivity implements TokenBusCallback, TransactionBusCallback {
    Rest_Adapter adapter;
    int shipping_address_id, payment_method_id, payment_bank_id;
    String access_token;
    SharedPreferences spf;
    ArrayAdapter adapterSpinnerAddress;
    ArrayAdapter adapterSpinnerPayment;
    List<Rowdata_Address> addresses;
    List<String> address_label_spinner;
    List<Rowdata_PaymentMethod> paymentMethods;
    List<String> payment_label_spinner;
    private Integer gross_amount;
    private String order_id = "344";
    @Bind(R.id.spinner_address)
    KufedSpinner spinner_address;
    @Bind(R.id.spinner_payment_method)
    KufedSpinner spinner_payment_method;

    @Bind(R.id.tv_address_detail)
    KufedTextView tv_address_detail;
    @Bind(R.id.tv_subtotal)
    KufedTextView tv_subtotal;
    @Bind(R.id.tv_shipping)
    KufedTextView tv_shipping;
    @Bind(R.id.tv_discount)
    KufedTextView tv_discount;
    @Bind(R.id.tv_total)
    KufedTextView tv_total;
    String token_veritrans;
    AlertDialog dialog;
//    @OnClick(R.id.img_back) public void click_back(){
//        finish();
//    }
//    @Bind(R.id.tv_title_custom)KufedTextViewTitle tv_title_custom;

    @Subscribe
    @Override
    public void onEvent(final GetTokenSuccessEvent getTokenSuccessEvent) {

        Observable<PojoCheckoutSubmit> observable = adapter.checkout_submit(
                access_token, String.valueOf(shipping_address_id), String.valueOf(shipping_address_id), "1",
                String.valueOf(payment_method_id),
                String.valueOf(payment_bank_id), "", "false", "");

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PojoCheckoutSubmit>() {
                    private boolean isSukses = false;

                    @Override
                    public void onCompleted() {
                        if (isSukses) {
                            TransactionRequest request = new TransactionRequest(order_id, gross_amount);
                            request.setCardPaymentInfo(getString(R.string.card_click_type_none), false);
                            VeritransSDK.getVeritransSDK().setTransactionRequest(request);
                            ItemDetails itemDetails = new ItemDetails("1", gross_amount, 1, "shoes");
                            ArrayList<ItemDetails> itemDetailsArrayList = new ArrayList<>();
                            itemDetailsArrayList.add(itemDetails);
                            CardTransfer transfer = new CardTransfer(
                                    new CardPaymentDetails(
                                            getTokenSuccessEvent.getResponse().getBank(),
                                            getTokenSuccessEvent.getResponse().getTokenId(),
                                            false),
                                    new TransactionDetails(String.valueOf(gross_amount), order_id),
                                    itemDetailsArrayList,
                                    new ArrayList<BillingAddress>(),
                                    new ArrayList<ShippingAddress>(),
                                    new CustomerDetails("Raka", "Mogandhi", "westumogandhi@gmail.com", "6285653956354")
                            );
                            VeritransSDK.getVeritransSDK().paymentUsingCard(transfer);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Error", e.getMessage().toString());
                    }

                    @Override
                    public void onNext(PojoCheckoutSubmit pojoCheckoutSubmit) {
                        if (pojoCheckoutSubmit.getStatus().getCode() == 200) {
                            order_id = pojoCheckoutSubmit.getData().getOrderId();
                            isSukses = true;
                        }

                    }
                });


    }

    @Subscribe
    @Override
    public void onEvent(GetTokenFailedEvent getTokenFailedEvent) {
        Log.e("veritrans", getTokenFailedEvent.getMessage().toString());

    }

    @Subscribe
    @Override
    public void onEvent(TransactionSuccessEvent transactionSuccessEvent) {
        Log.e("veritrans", transactionSuccessEvent.toString());
    }

    @Subscribe
    @Override
    public void onEvent(TransactionFailedEvent transactionFailedEvent) {
        Log.e("veritrans", transactionFailedEvent.getMessage().toString());
    }

    @Subscribe
    @Override
    public void onEvent(NetworkUnavailableEvent networkUnavailableEvent) {
        Log.e("veritrans", networkUnavailableEvent.toString());
    }

    @Subscribe
    @Override
    public void onEvent(GeneralErrorEvent generalErrorEvent) {
        Log.e("veritrans", generalErrorEvent.getMessage().toString());
    }

    @OnClick(R.id.btn)
    public void submit_checkout() {
        Log.e("payment_method_id", String.valueOf(payment_method_id));
        Log.e("payment_bank_id", String.valueOf(payment_bank_id));
        Log.e("shipping_address_id", String.valueOf(shipping_address_id));
        Log.e("payment_address_id", String.valueOf(shipping_address_id));
        Log.e("shopping", "_provider_method_id = 1");

//        String clientkey = VeritransSDK.getVeritransSDK().getClientKey();
//        CardTokenRequest cardTokenRequest = new CardTokenRequest(
//                "4811111111111114","123","01","2020", VeritransSDK.getVeritransSDK().getClientKey()
//        );
//        cardTokenRequest.setIsSaved(false);
//        cardTokenRequest.setGrossAmount(gross_amount);
//        VeritransSDK.getVeritransSDK().getToken(cardTokenRequest);

        payment();

    }

    private void payment() {
        VTConfig.CLIENT_KEY = Param_Collection.VT_CLIENT;
        VTConfig.VT_IsProduction = false;

        VTCardDetails cardDetails = new VTCardDetails();
        cardDetails.setCard_number("4811111111111114");
        cardDetails.setCard_cvv("123");
        cardDetails.setCard_exp_month(1);
        cardDetails.setCard_exp_year(2020);
        cardDetails.setGross_amount(String.valueOf(gross_amount));
//        cardDetails.setGross_amount("10000");
        cardDetails.setSecure(true);

        VTDirect vtDirect = new VTDirect();
        vtDirect.setCard_details(cardDetails);

        vtDirect.getToken(new ITokenCallback() {
            @Override
            public void onSuccess(final VTToken vtToken) {
                token_veritrans = vtToken.getToken_id();
                final String token_bank = vtToken.getBank();
                Observable<PojoCheckoutSubmit> observable = adapter.checkout_submit(
                        access_token, String.valueOf(shipping_address_id), String.valueOf(shipping_address_id), "1",
                        String.valueOf(payment_method_id),
                        String.valueOf(payment_bank_id), "", "false", "");

                observable.subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<PojoCheckoutSubmit>() {
                            private boolean isSukses = false;

                            @Override
                            public void onCompleted() {
                                if (isSukses) {
                                    Intent intent3DSWebview = new Intent(getApplicationContext(), Activity_Webview.class);
                                    intent3DSWebview.putExtra("token",token_veritrans);
                                    intent3DSWebview.putExtra("bank",token_bank);
                                    intent3DSWebview.putExtra("url",vtToken.getRedirect_url());
                                    startActivityForResult(intent3DSWebview, 999);

//                                    TransactionRequest request = new TransactionRequest(order_id, gross_amount);
//                                    request.setCardPaymentInfo(getString(R.string.card_click_type_none), true);
//                                    VeritransSDK.getVeritransSDK().setTransactionRequest(request);
//                                    ItemDetails itemDetails = new ItemDetails("1", gross_amount, 1, "shoes");
//                                    ArrayList<ItemDetails> itemDetailsArrayList = new ArrayList<>();
//                                    itemDetailsArrayList.add(itemDetails);
//                                    CardTransfer transfer = new CardTransfer(
//                                            new CardPaymentDetails(
//                                                    token_veritrans,
//                                                    token_bank,
//                                                    false),
//                                            new TransactionDetails(String.valueOf(gross_amount), order_id),
//                                            itemDetailsArrayList,
//                                            new ArrayList<BillingAddress>(),
//                                            new ArrayList<ShippingAddress>(),
//                                            new CustomerDetails("Raka", "Mogandhi", "westumogandhi@gmail.com", "6285653956354")
//                                    );
//                                    VeritransSDK.getVeritransSDK().paymentUsingCard(transfer);
                                }

                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("Error", e.getMessage().toString());
                            }

                            @Override
                            public void onNext(PojoCheckoutSubmit pojoCheckoutSubmit) {
                                if (pojoCheckoutSubmit.getStatus().getCode() == 200) {
                                    order_id = pojoCheckoutSubmit.getData().getOrderId();
                                    isSukses = true;
                                }

                            }
                        });
            }

            @Override
            public void onError(Exception e) {

                Log.e("token", e.getMessage().toString());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 999){
            Rest_Adapter adapter = Public_Functions.initRetrofit_Temp();

            Observable<PojoResponseVeritrans> observable =
                    adapter.send_tokenveritrans_to_backend(token_veritrans, order_id,String.valueOf(gross_amount));
            observable.subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<PojoResponseVeritrans>() {
                        @Override
                        public void onCompleted() {
                            Log.e("","");
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e("","");
                        }

                        @Override
                        public void onNext(PojoResponseVeritrans pojoResponseVeritrans) {
                            Log.e("","");
                        }
                    });

        }
//        if(requestCode == 999 && resultCode == RESULT_OK){
//            finish();
//            Toast.makeText(getApplicationContext(), "Payment SUKSES", Toast.LENGTH_LONG).show();
//        }else{
//            Toast.makeText(getApplicationContext(), "Payment FAIL", Toast.LENGTH_LONG).show();
//        }
    }

    @Override
    protected void onDestroy() {
        VeritransBusProvider.getInstance().unregister(this);
        super.onDestroy();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_onepage);
        ButterKnife.bind(this);

        VeritransBusProvider.getInstance().register(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setBackground(ContextCompat.getDrawable(MainMenu.this, R.drawable.bg_actionbar_gradient));
//        toolbar.setBackgroundColor(ContextCompat.getColor(MainMenu.this, android.R.color.black));
        setSupportActionBar(toolbar);
        adapter = Public_Functions.initRetrofit();
        LayoutInflater mInflater = LayoutInflater.from(getApplicationContext());
        View view = mInflater.inflate(R.layout.layout_custom_toolbar_title, null);

        KufedTextViewTitle tv_title = (KufedTextViewTitle) view.findViewById(R.id.tv_title_custom);
        tv_title.setText("CHECKOUT");
        toolbar.removeAllViews();
        toolbar.setTitle("");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.addView(view);

        spf = getSharedPreferences(Param_Collection.SPF_NAME, MODE_PRIVATE);
        access_token = spf.getString(Param_Collection.ACCESS_TOKEN, "");

        getCheckoutAllData();
    }

    public void getCheckoutAllData() {
        Observable<PojoCheckoutGet> observable = adapter.get_checkout_allinfo(access_token);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PojoCheckoutGet>() {
                    private boolean isSukses = false;

                    @Override
                    public void onCompleted() {
                        Log.e("", "");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Error Get Data", e.getMessage().toString());
                    }

                    @Override
                    public void onNext(PojoCheckoutGet pojoCheckoutGet) {
                        Log.e("", "");
                        if (pojoCheckoutGet.getStatus().getCode() == 200) {
                            tv_subtotal.setText("IDR " + pojoCheckoutGet.getData().getCart().getOriginalTotalPrice());
                            tv_shipping.setText("IDR 0");
                            tv_discount.setText("IDR 0");
                            tv_total.setText("IDR " + pojoCheckoutGet.getData().getCart().getTotalPrice());

                            gross_amount = pojoCheckoutGet.getData().getCart().getTotalPrice();

                            if (pojoCheckoutGet.getData().getAddress().size() > 0) {
                                isSukses = true;
                                addresses = new ArrayList<Rowdata_Address>();
                                address_label_spinner = new ArrayList<String>();
                                for (PojoCheckoutGet.Address item : pojoCheckoutGet.getData().getAddress()) {
//                                shipping_address_id = pojoResponseAddressList.getData().getAddresses().get(0).getId();
                                    addresses.add(new Rowdata_Address(item.getId(), item.getAddressLabel(), item.getAddressDetail()));
                                    address_label_spinner.add(item.getAddressLabel());
                                }

                                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                                        getApplicationContext(), R.layout.spinner_item_black, address_label_spinner);
                                spinner_address.setAdapter(arrayAdapter);
                                spinner_address.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        tv_address_detail.setText(addresses.get(position).getAddressDetail());
                                        shipping_address_id = addresses.get(position).getId();
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {
                                        tv_address_detail.setText(addresses.get(0).getAddressDetail());
                                        shipping_address_id = addresses.get(0).getId();

                                    }
                                });

                            }

                            if (pojoCheckoutGet.getData().getPaymentMethod().size() > 0) {
                                paymentMethods = new ArrayList<Rowdata_PaymentMethod>();
                                payment_label_spinner = new ArrayList<String>();
                                for (PojoCheckoutGet.PaymentMethod item : pojoCheckoutGet.getData().getPaymentMethod()) {
                                    paymentMethods.add(new Rowdata_PaymentMethod(item.getMethodId(),
                                            item.getMethodCode(), item.getMethodName(), item.getMethodDescription(),
                                            item.getEnable()));
                                    payment_label_spinner.add(item.getMethodName());
                                }

                                ArrayAdapter<String> arrayAdapterPayment = new ArrayAdapter<String>(
                                        getApplicationContext(), R.layout.spinner_item_black, payment_label_spinner);
                                spinner_payment_method.setAdapter(arrayAdapterPayment);
                                spinner_payment_method.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        payment_method_id = paymentMethods.get(position).methodId;
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {
                                        payment_method_id = paymentMethods.get(0).methodId;

                                    }
                                });
                            }
                            isSukses = true;
                        }
                    }
                });
    }

    public void getCheckoutFee() {
        Observable<PojoCheckoutFee> observable = adapter.get_checkoutfee(access_token);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PojoCheckoutFee>() {
                    private boolean isSukses = false;

                    @Override
                    public void onCompleted() {
                        Log.e("", "");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("", "");
                    }

                    @Override
                    public void onNext(PojoCheckoutFee pojoCheckoutFee) {
                        if (pojoCheckoutFee.getStatus().getCode() == 200) {
                            tv_subtotal.setText("IDR " + pojoCheckoutFee.getData().getCart().getOriginalTotalPrice());
                            tv_shipping.setText("IDR 0");
                            tv_discount.setText("IDR 0");
                            tv_total.setText("IDR " + pojoCheckoutFee.getData().getCart().getTotalPrice());

                        }

                    }
                });
    }

    public void getAddressInfo() {

        Observable<PojoResponseAddressList> observable = adapter.get_address_list(access_token);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PojoResponseAddressList>() {
                    private boolean isSukses = false;

                    @Override
                    public void onCompleted() {
                        Log.e("", "");

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Error Address Info", e.getMessage().toString());
                        Toast.makeText(getApplicationContext(), "Something Wrong", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(PojoResponseAddressList pojoResponseAddressList) {
                        Log.e("", "");
                        if (pojoResponseAddressList.getData().getAddresses().size() > 0) {
                            isSukses = true;
                            addresses = new ArrayList<Rowdata_Address>();
                            address_label_spinner = new ArrayList<String>();
                            for (PojoResponseAddressList.Data.Address item : pojoResponseAddressList.getData().getAddresses()) {
//                                shipping_address_id = pojoResponseAddressList.getData().getAddresses().get(0).getId();
                                addresses.add(new Rowdata_Address(item.getId(), item.getAddressLabel(), item.getAddressDetail()));
                                address_label_spinner.add(item.getAddressLabel());
                            }

                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                                    getApplicationContext(), R.layout.spinner_item_black, address_label_spinner);
                            spinner_address.setAdapter(arrayAdapter);
                            spinner_address.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    tv_address_detail.setText(addresses.get(position).getAddressDetail());
                                    shipping_address_id = addresses.get(position).getId();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                    tv_address_detail.setText(addresses.get(0).getAddressDetail());
                                    shipping_address_id = addresses.get(0).getId();

                                }
                            });

                        }

                    }
                });

    }


}
