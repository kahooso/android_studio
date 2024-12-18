package com.example.thirtysixth;

import android.os.Bundle;
import android.widget.ListView;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        ListView listView = findViewById(R.id.listView);

        try {

            XmlPullParser xpp = prepareXpp();
            List<TestValute> valuteList = parseXML(xpp);

            ValuteAdapter adapter = new ValuteAdapter(this, R.layout.xml_res, valuteList);
            listView.setAdapter(adapter);

        } catch (XmlPullParserException | IOException e) {

            e.printStackTrace();
            Log.e("Error", "Ошибка парсинга XML: " + e.getMessage());
        }
    }

    List<TestValute> parseXML(XmlPullParser xpp) throws XmlPullParserException, IOException {

        List<TestValute> valuteList = new ArrayList<>();

        String tagName = null;
        String textNumCode = null;
        String textCharCode = null;
        String textName = null;
        String textValue = null;

        while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {
            switch (xpp.getEventType()) {
                case XmlPullParser.START_TAG:
                    tagName = xpp.getName();
                    break;

                case XmlPullParser.TEXT:
                    if ("NumCode".equals(tagName)) {
                        textNumCode = xpp.getText();
                    } else if ("CharCode".equals(tagName)) {
                        textCharCode = xpp.getText();
                    } else if ("Name".equals(tagName)) {
                        textName = xpp.getText();
                    } else if ("Value".equals(tagName)) {
                        textValue = xpp.getText() != null ? xpp.getText().replace(',', '.') : "0";
                    }
                    break;

                case XmlPullParser.END_TAG:
                    if ("Valute".equals(xpp.getName())) {
                        try {
                            float value = Float.parseFloat(textValue);
                            TestValute valute = new TestValute(textNumCode, textCharCode, textName, value);
                            valuteList.add(valute);
                        } catch (NumberFormatException e) {
                            Log.e("XMLParsing", "Ошибка преобразования значения: " + textValue, e);
                        }
                        textNumCode = null;
                        textCharCode = null;
                        textName = null;
                        textValue = null;
                    }
                    break;

                default:
                    break;
            }
            xpp.next();
        }
        return valuteList;
    }

    XmlPullParser prepareXpp() throws XmlPullParserException, IOException {

        return getResources().getXml(R.xml.data);
    }
}