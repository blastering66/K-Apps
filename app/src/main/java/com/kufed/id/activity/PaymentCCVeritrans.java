package com.kufed.id.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.kufed.id.api.VTModel.VTToken;
import com.kufed.id.util.Param_Collection;

import com.kufed.id.api.VTDirect;
import com.kufed.id.api.VTInterface.ITokenCallback;
import com.kufed.id.api.VTModel.VTCardDetails;
import com.kufed.id.api.VTUtil.VTConfig;
/**
 * Created by macbook on 8/5/16.
 */
public class PaymentCCVeritrans extends AppCompatActivity {
    private String cToken, cBank;
    private boolean success = false;
    private String urlRedirect;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    private VTCardDetails CardFactory(boolean secure, String card_number,
                                      String ccv, int exp_month, int exp_year,
                                      String amount) {
        VTCardDetails cardDetails = new VTCardDetails();
//		cardDetails.setCard_number("4811111111111114");
        cardDetails.setCard_number(card_number);
        cardDetails.setCard_cvv(ccv);
        cardDetails.setCard_exp_month(exp_month);
        cardDetails.setCard_exp_year(exp_year);
        cardDetails.setSecure(secure);
//	        cardDetails.setGross_amount(totalPrice+"");
        cardDetails.setGross_amount(amount);
        return cardDetails;
    }

    public void getToken(){

        VTConfig.VT_IsProduction = true;
        VTConfig.CLIENT_KEY = Param_Collection.VT_CLIENT;
        VTDirect vtDirect = new VTDirect();
//        VTCardDetails cardDetails = CardFactory(true, "cCardNumber", "cCCV", "exp_Month", "exp_Year", "cAmount");
        VTCardDetails cardDetails = CardFactory(true, "cCardNumber", "cCCV", 11, 21, "cAmount");
//        vtDirect.setCard_details(cardDetails);
//        vtDirect.getToken(new ITokenCallback(){
//            @Override
//            public void onSuccess(VTToken token) {
//                if (token.getRedirect_url() != null) {
//                    Log.e("VtLog Redirect URL", token.getRedirect_url());
//                    success = true;
//                }
//                Log.e("VtLog Token", token.getToken_id());
//                cToken = token.getToken_id();
//                cBank = token.getBank();
//                Intent intent = new Intent(getApplicationContext(), Activity_Webview.class);
//                intent.putExtra("url", token.getRedirect_url());
//                intent.putExtra("token",cToken);
//                intent.putExtra("bank", cBank);
//                intent.putExtra("total", "cAmount");
//                startActivity(intent);
//                finish();
//            }
//            @Override
//            public void onError(Exception error) {
//            }
//        });
    }
}
