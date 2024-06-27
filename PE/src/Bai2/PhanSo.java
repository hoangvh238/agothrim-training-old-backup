package Bai2;

import java.util.Comparator;

public class PhanSo implements Comparable<PhanSo> {

    int topNum;
    int botNum;

    public PhanSo(int topNum, int botNum) throws Validation {
        if(botNum==0) throw new Validation("Mau so khong duoc bang 0");
        int wishMax  = wishMax(topNum,botNum);
        this.topNum = topNum/wishMax;
        this.botNum = botNum/wishMax;
    }

    public PhanSo add(PhanSo phanSo) throws Validation {
        if(phanSo.botNum==this.botNum)
            return new PhanSo(this.topNum+phanSo.topNum,this.botNum);
        return new PhanSo(this.topNum* phanSo.botNum+ phanSo.topNum*this.botNum, this.botNum*phanSo.botNum);
    }

    public PhanSo subtract(PhanSo phanSo) throws Validation
    {
        if(phanSo.botNum==this.botNum) return new PhanSo(this.topNum-phanSo.topNum,this.botNum);
        return new PhanSo(this.topNum* phanSo.botNum - phanSo.topNum*this.botNum, this.botNum*phanSo.botNum);
    }

    public PhanSo multiply(PhanSo phanSo) throws Validation
    {
        return new PhanSo(this.topNum*phanSo.topNum,this.botNum*phanSo.botNum);
    }

    public PhanSo divide(PhanSo phanSo) throws  Validation
    {
        return new PhanSo(this.topNum*phanSo.botNum,this.botNum*phanSo.topNum);
    }

    public int wishMax(int a,int b)
    {
        if(b==0)
        {
            return a;
        }
        return wishMax(b,a%b);
    }

    public String compare(PhanSo phanSo)
    {
        if(this.compareTo(phanSo) > 0) return this.toString()+"Bigger than"+phanSo.toString();
        else if(this.compareTo(phanSo)<0) return this.toString()+"Smaller than "+phanSo.toString();
        else return this.toString()+"Equal than"+phanSo.toString();
    }
    @Override
    public String toString() {
        return topNum+"/"+botNum;
    }


    @Override
    public int compareTo(PhanSo o) {
        return Integer.compare(this.topNum / this.botNum, o.topNum / o.botNum);
    }
}


