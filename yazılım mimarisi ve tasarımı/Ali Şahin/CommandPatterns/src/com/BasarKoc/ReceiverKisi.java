package com.BasarKoc;

public class ReceiverKisi {
    private Kisi _EntityKisi;
    public ReceiverKisi(Kisi kisi) {

    }

    public void ekle() {
        System.out.println("Eklendi"+_EntityKisi.ad);
    }
    public void sil(){
        System.out.println("Silindi:"+_EntityKisi.id);
    }
}
