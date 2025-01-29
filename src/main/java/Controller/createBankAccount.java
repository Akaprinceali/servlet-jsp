package Controller;

import java.io.IOException;
import java.util.List;



import Dao.BankDao;
import Dao.CustomerDao;
import Dto.Bank_account;
import Dto.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/createbankaccount")
public class createBankAccount extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String accType=req.getParameter("accounttype");
		Customer customer=(Customer) req.getSession().getAttribute("customer");
		
		List<Bank_account> list=customer.getBankaccounts();
		
		boolean flag= true;
		
		for(Bank_account bank_account: list)
		{
			if(bank_account.getAccount_type().equals(accType))
			{
				flag=false;
				break;
			}
		}
		
		if(flag==true)
		{
			Bank_account bank_account = new Bank_account();
			
			bank_account.setAccount_type(accType);
			
			if(bank_account.getAccount_type().equals("savings"))
				bank_account.setAcc_limit(10000);
			else
				bank_account.setAcc_limit(15000);
			
			bank_account.setCustomer(customer);
			
			BankDao bankDao= new BankDao();
			
			bankDao.save_account(bank_account);
			
			List<Bank_account> list2=list;
			list2.add(bank_account);
			customer.setBankaccounts(list2);
			
			CustomerDao customerDao=new CustomerDao();
			customerDao.update(customer);
			
			res.getWriter().print("<h1>Congratulations your account has been created successfully</h1>");
			
		}
		else
		{
			res.getWriter().print("<h1>This account already exists</h1>");
		}
		
		
	}
	
}
