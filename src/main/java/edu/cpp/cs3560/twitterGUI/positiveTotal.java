package edu.cpp.cs3560.twitterGUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;

public class positiveTotal implements visitor {

    @Override
    public int visitUser(user user) {
        int count = 0;

        if (user.getClass() == single.class) {
            count += visitSingle(user);
        } else if (user.getClass() == group.class) {
            count += visitGroup(user);
        }

        return count;
    }

    @Override
    public int visitSingle(user user) {
        return ((single) user).getPositiveMessageCount();
    }

    @Override
    public int visitGroup(user user) {
        int count = 0;

        for (user u : ((group) user).getGroupUsers().values()) {
            count += visitUser(u);
        }

        return count;
    }

}