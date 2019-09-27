package com.introvd.template.template.download.web;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.common.FragmentBase;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.slide.p392a.C8460a;
import com.introvd.template.sdk.utils.C8555k;
import com.introvd.template.template.R;
import com.introvd.template.template.p409g.C8762d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@C1942a(mo10417rZ = "/TemplateD/WebDownload")
public class WebTemplateDownloadFragment extends FragmentBase implements C8709a {
    private TODOParamModel cyQ;
    private C8710b elX;

    private void aKz() {
        if (this.cyQ == null) {
            if (this.resultCallback != null) {
                this.resultCallback.onResult(-1);
            }
            return;
        }
        JSONObject jsonObj = this.cyQ.getJsonObj();
        int activityFlag = this.cyQ.getActivityFlag();
        if (this.cyQ.mTODOCode == 423) {
            if (getActivity() instanceof EventActivity) {
                ((EventActivity) getActivity()).mo22814FW();
                ((EventActivity) getActivity()).mo22812FU();
            }
            C8762d.aMt().mo35219Q(getContext(), true);
            Long k = C8460a.m24499k(jsonObj);
            if (C8762d.aMt().mo35228bE(k.longValue())) {
                EffectInfoModel effectInfoModel = new EffectInfoModel();
                effectInfoModel.mType = "bgm";
                effectInfoModel.mTemplateId = k.longValue();
                effectInfoModel.setmUrl(C8460a.m24500l(jsonObj));
                ArrayList arrayList = new ArrayList();
                arrayList.add(effectInfoModel);
                this.elX.mo35091cP(arrayList);
                this.elX.mo35089aY(getActivity());
            } else if (this.resultCallback != null) {
                this.resultCallback.onResult(-1);
            }
        } else if (activityFlag != 0) {
            if (C8555k.m25013s(jsonObj) > 0) {
                List r = C8555k.m25012r(jsonObj);
                if (!this.elX.mo35090cO(r)) {
                    this.elX.mo35091cP(r);
                    this.elX.mo35089aY(getActivity());
                } else if (this.resultCallback != null) {
                    this.resultCallback.onResult(-1);
                }
            } else if (this.resultCallback != null) {
                this.resultCallback.onResult(-1);
            }
        } else if (this.resultCallback != null) {
            this.resultCallback.onResult(-1);
        }
    }

    /* renamed from: jC */
    public void mo35086jC(boolean z) {
        if (this.resultCallback != null) {
            this.resultCallback.onResult(z ? 1 : 0);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (getArguments() != null) {
            this.cyQ = (TODOParamModel) getArguments().getParcelable(TodoConstants.KEY_TODOCODE_PARAM_MODEL);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.elX = new C8710b();
        this.elX.attachView((C8709a) this);
        this.elX.mo35088aX(getActivity());
        aKz();
        return layoutInflater.inflate(R.layout.fragment_web_template_download, viewGroup, false);
    }

    public void onDetach() {
        super.onDetach();
    }

    public void setFragmentParams(Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            TODOParamModel tODOParamModel = objArr[0];
            if (tODOParamModel instanceof TODOParamModel) {
                this.cyQ = tODOParamModel;
                aKz();
            }
        }
    }
}
