package com.yjr;

import javax.crypto.spec.OAEPParameterSpec;
import java.nio.file.OpenOption;

/**
 * @author yangjiuran
 * @Date 2020/6/24
 */
public class Inversion {
    public static void main(String[] args) {

        openAndClose openAndClose = new openAndClose(new changhong());
        openAndClose.open();
    }
    interface IopenAndClose{
        void open();
    }
    interface ITV{
        void play();
    }
    static class changhong implements ITV{

        @Override
        public void play() {
            System.out.println("长虹电视播放了");
        }
    }
    static class openAndClose implements IopenAndClose{
        public ITV itv;

        public openAndClose(ITV itv) {
            this.itv = itv;
        }

        @Override
        public void open() {
            itv.play();
        }
    }
}
