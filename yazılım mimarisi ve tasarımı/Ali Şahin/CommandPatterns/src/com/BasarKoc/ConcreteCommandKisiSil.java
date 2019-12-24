package com.BasarKoc;

public class ConcreteCommandKisiSil extends CommandKisi {
    public ConcreteCommandKisiSil(ReceiverKisi receiverKisi) {
        super(receiverKisi);
    }

    @Override
    public void Execute() {
_receiverKisi.sil();
    }
}
