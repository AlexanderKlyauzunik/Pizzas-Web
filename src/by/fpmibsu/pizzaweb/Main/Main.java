package src.by.fpmibsu.pizzaweb.Main;


import src.by.fpmibsu.pizzaweb.Dao.DaoImpl.RoleDaoImpl;
import src.by.fpmibsu.pizzaweb.Entity.Role;

import java.util.ArrayList;
import java.util.List;

public class Main{
        public static void main(String[] args) {
            Role role = new Role(6L,"dgasgdg");
            RoleDaoImpl roleDao = new RoleDaoImpl();
            roleDao.delete(6L);

            System.out.println(role);
        }
}
