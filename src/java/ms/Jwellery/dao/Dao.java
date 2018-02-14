/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.dao;

import java.util.List;
import ms.Jwellery.model.LoginDetailsBean;
import ms.Jwellery.model.UserRegistrationBean;
import ms.Jwellery.model.WorkerRegistrationBean;

/**
 *
 * @author Suvh
 */
public interface Dao {

    public boolean RegistrationUser(WorkerRegistrationBean registration) throws RuntimeException;

    public boolean getEmailValidation(String email) throws RuntimeException;

    public boolean getADHARValidation(String adhar) throws RuntimeException;

    public LoginDetailsBean userAuthentication(LoginDetailsBean loginDetails) throws RuntimeException;

    public LoginDetailsBean getImage(String Phone)throws RuntimeException;

    public List<LoginDetailsBean> getAllWorker()throws RuntimeException;
    
}
