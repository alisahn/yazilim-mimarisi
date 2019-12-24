package com.BasarKoc;

import java.util.ArrayList;
import java.util.List;

public class İnvokerKisi {
    public List<CommandKisi> CommandKisiList;

    public List<CommandKisi> getCommandKisiList() {
        return CommandKisiList;
    }

    public void setCommandKisiList(List<CommandKisi> commandKisiList) {
        CommandKisiList = commandKisiList;
    }
    public İnvokerKisi()
    {
        CommandKisiList = new ArrayList<>();
    }
    public void ExecuteAll() {
        if (CommandKisiList.size() == 0)
            return;

        for (CommandKisi item : CommandKisiList) {

            item.Execute();
        }
    }
}
