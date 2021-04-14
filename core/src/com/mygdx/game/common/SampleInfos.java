package com.mygdx.game.common;

import com.mygdx.game.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SampleInfos {
    public static final List<SampleInfo> All = Arrays.asList(
        ApplicationListenerSample.SAMPLE_INFO,
        GdxReflactionSample.SAMPLE_INFO,
        InputListeningSample.SAMPLE_INFO,
        InputPollingSample.SAMPLE_INFO,
        ModelinfoSample.SAMPLE_INFO,
        MyGdxGame.SAMPLE_INFO,
        OrthographicCameraSample.SAMPLE_INFO
    );

    public static List<String> getSampleName(){
        List<String> ret = new ArrayList<>();
        for(SampleInfo info: All){
            ret.add(info.getName());
        }
        Collections.sort(ret);
        return ret;
    }

    public static SampleInfo find(String name){
        if(name==null||name.isEmpty()){
            throw new IllegalArgumentException("Name argument is require.");
        }

        SampleInfo ret = null;

        for(SampleInfo info: All){
            if(info.getName().equals(name)){
                ret = info;
                break;
            }
        }
        if(ret==null){
            throw new IllegalArgumentException("Could not find sample with name "+name);
        }

        return ret;
    }

    private SampleInfos(){}
}
