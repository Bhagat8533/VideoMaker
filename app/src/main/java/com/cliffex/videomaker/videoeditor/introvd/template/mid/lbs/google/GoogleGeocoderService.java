package com.introvd.template.mid.lbs.google;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.common.ExAsyncTask;
import com.introvd.template.mid.lbs.AbsPlaceService;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.lbs.LocationInfo;
import com.introvd.template.router.lbs.PlaceListener;
import com.p131c.p132a.p135c.C2575a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@C1942a(mo10417rZ = "/lbs/google_place")
public class GoogleGeocoderService extends AbsPlaceService {
    /* access modifiers changed from: private */
    public Context mContext = null;

    public void init(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void query(Context context, String str, final String str2, int i, final int i2, PlaceListener placeListener) {
        if (str2 != null && str2.contains(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP) && placeListener != null) {
            final WeakReference weakReference = new WeakReference(placeListener);
            try {
                new ExAsyncTask<Void, Integer, List<LocationInfo>>() {
                    /* renamed from: cd */
                    private void m22326cd(List<LocationInfo> list) {
                        PlaceListener placeListener = (PlaceListener) weakReference.get();
                        if (placeListener != null) {
                            placeListener.onPlace(list);
                        }
                    }

                    /* access modifiers changed from: protected */
                    /* renamed from: ce */
                    public void onCancelled(List<LocationInfo> list) {
                        m22326cd(null);
                        super.onCancelled(list);
                    }

                    /* access modifiers changed from: protected */
                    public List<LocationInfo> doInBackground(Void... voidArr) {
                        ArrayList arrayList = new ArrayList();
                        try {
                            String[] split = str2.split(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
                            List fromLocation = new Geocoder(GoogleGeocoderService.this.mContext).getFromLocation(C2575a.parseDouble(split[0]), C2575a.parseDouble(split[1]), i2);
                            if (fromLocation == null) {
                                return null;
                            }
                            for (int i = 0; i < fromLocation.size(); i++) {
                                Address address = (Address) fromLocation.get(i);
                                LocationInfo locationInfo = new LocationInfo();
                                locationInfo.mCountry = address.getCountryName();
                                locationInfo.mProvince = address.getAdminArea();
                                locationInfo.mCity = address.getLocality();
                                String str = "";
                                for (int i2 = 0; i2 < address.getMaxAddressLineIndex(); i2++) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(str);
                                    sb.append(address.getAddressLine(i2));
                                    str = sb.toString();
                                }
                                locationInfo.mAddressStr = address.getFeatureName();
                                locationInfo.mAddressStrDetail = str;
                                locationInfo.mLatitude = address.getLatitude();
                                locationInfo.mLongitude = address.getLongitude();
                                arrayList.add(locationInfo);
                            }
                            return arrayList;
                        } catch (Exception unused) {
                        }
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(List<LocationInfo> list) {
                        m22326cd(list);
                        super.onPostExecute(list);
                    }
                }.execute((Params[]) new Void[0]);
            } catch (Exception unused) {
            }
        }
    }

    public void unInit() {
    }
}
