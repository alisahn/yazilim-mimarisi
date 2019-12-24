package com.BasarKoc;

public class ConcreteCommandKisiEkle extends CommandKisi {
    public ConcreteCommandKisiEkle(ReceiverKisi receiverKisi) {
        super(receiverKisi);
    }

    @Override
    public void Execute() {
 _receiverKisi.ekle();
    }
}
