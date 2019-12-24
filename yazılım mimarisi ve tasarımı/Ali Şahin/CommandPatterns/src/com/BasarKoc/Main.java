package com.BasarKoc;

public class Main {

    public static void main(String[] args) {
        Kisi kisi = new Kisi();

        ReceiverKisi rk1 = new ReceiverKisi(kisi);

        CommandKisi ckAdd = new ConcreteCommandKisiEkle(rk1);
        CommandKisi ckSil = new ConcreteCommandKisiSil(rk1);

        İnvokerKisi ik = new İnvokerKisi();

        ik.CommandKisiList.add(ckAdd);
        ik.CommandKisiList.add(ckSil);

        ik.ExecuteAll();
    }
}
