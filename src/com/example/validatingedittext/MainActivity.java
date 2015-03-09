package com.example.validatingedittext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity
{


	EditText name_et,email_et,mobno_et,enterpassword_et,confirmpassword_et;
	Spinner sp;
	Button submit;
	RadioButton r1,r2;
	
	String[] country={"Select country","Afghanistan","Albania","Algeria","Andorra","Angola","Anguilla","Antigua &amp; Barbuda",
					"Argentina","Armenia","Aruba","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh",
					"Barbados","Belarus","Belgium","Belize","Benin","Bermuda","Bhutan","Bolivia","Bosnia &amp; Herzegovina",
					"Botswana","Brazil","British Virgin Islands","Brunei","Bulgaria","Burkina Faso","Burundi","Cambodia","" +
					"Cameroon","Cape Verde","Cayman Islands","Chad","Chile","China","Colombia","Congo","Cook Islands",
					"Costa Rica","Cote D Ivoire","Croatia","Cruise Ship","Cuba","Cyprus","Czech Republic","Denmark",
					"Djibouti","Dominica","Dominican Republic","Ecuador","Egypt","El Salvador","Equatorial Guinea",
					"Estonia","Ethiopia","Falkland Islands","Faroe Islands","Fiji","Finland","France","French Polynesia",
					"French West Indies","Gabon","Gambia","Georgia","Germany","Ghana","Gibraltar","Greece","Greenland",
					"Grenada","Guam","Guatemala","Guernsey","Guinea","Guinea Bissau","Guyana","Haiti","Honduras","Hong Kong",
					"Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Isle of Man","Israel","Italy","Jamaica",
					"Japan","Jersey","Jordan","Kazakhstan","Kenya","Kuwait","Kyrgyz Republic","Laos","Latvia","Lebanon","Lesotho",
					"Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macau","Macedonia","Madagascar","Malawi","Malaysia",
					"Maldives","Mali","Malta","Mauritania","Mauritius","Mexico","Moldova","Monaco","Mongolia","Montenegro","Montserrat",
					"Morocco","Mozambique","Namibia","Nepal","Netherlands","Netherlands Antilles","New Caledonia","New Zealand","Nicaragua",
					"Niger","Nigeria","Norway","Oman","Pakistan","Palestine","Panama","Papua New Guinea","Paraguay","Peru","Philippines",
					"Poland","Portugal","Puerto Rico","Qatar","Reunion","Romania","Russia","Rwanda","Saint Pierre &amp; Miquelon",
					"Samoa","San Marino","Satellite","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore",
					"Slovakia","Slovenia","South Africa","South Korea","Spain","Sri Lanka","St Kitts &amp; Nevis","St Lucia",
					"St Vincent","St. Lucia","Sudan","Suriname","Swaziland","Sweden","Switzerland","Syria","Taiwan","Tajikistan",
					"Tanzania","Thailand","Timor L'Este","Togo","Tonga","Trinidad &amp; Tobago","Tunisia","Turkey","Turkmenistan",
					"Turks &amp; Caicos","Uganda","Ukraine","United Arab Emirates",
					"United Kingdom","Uruguay","Uzbekistan","Venezuela","Vietnam","Virgin Islands (US)","Yemen","Zambia","Zimbabwe"};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		name_et=(EditText)findViewById(R.id.editText1);
		email_et=(EditText)findViewById(R.id.editText2);
		mobno_et=(EditText)findViewById(R.id.editText3);
		enterpassword_et=(EditText)findViewById(R.id.editText4);
		confirmpassword_et=(EditText)findViewById(R.id.editText5);
		sp=(Spinner)findViewById(R.id.spinner1);
		r1=(RadioButton)findViewById(R.id.radioButton1);
		r2=(RadioButton)findViewById(R.id.radioButton2);
		
				submit=(Button)findViewById(R.id.button1);
		
		submit.setOnClickListener(new OnClickListener() 
		{
						@Override
			public void onClick(View arg0)
			{
				// TODO Auto-generated method stub		 
				  				
				/**Validating Email**/
				final String email = email_et.getText().toString();
				final String name = name_et.getText().toString();
				final String mobno = mobno_et.getText().toString();
				final String enterpassword = enterpassword_et.getText().toString();
				 final String strPwd = enterpassword_et.getText().toString();
				  final String strConfPwd = confirmpassword_et.getText().toString();
				{
				if (!isValidEmail(email)) 
				{
					email_et.setError("Invalid Email");
				}
				
				
				/**Validating Name**/
				
				else if (!isValidName(name)) 
				{
					name_et.setError("Pls Enter your Name");
				}
				
				
				
				/**Validating Mobile Number**/
				
				else if (!isValidMobileNumber(mobno)) 
				{
					mobno_et.setError("Pls Check your Mobile Number");
				}
				
				
				/**Validating password**/
				
				
				else if (!isValidPassword(enterpassword)) 
				{
					
					enterpassword_et.setError("Password Should contain a a capital letter,number and special character;");
					
				}

				 /**Validating Spinner**/
				else if (sp.getSelectedItem()=="Select country")
				  {
					  Toast.makeText(MainActivity.this,"Select your Country", Toast.LENGTH_LONG).show();  
				  }
				  /**Validating Radio button**/
				else if (r1.isChecked()==false&&r2.isChecked()==false)
				  {
					  
					  Toast.makeText(MainActivity.this,"Select Gender", Toast.LENGTH_LONG).show();  
				  }
				  /**Validating Password**/
				 
				  
				else if(!strPwd.equals(strConfPwd))
				  {
				  Toast.makeText(MainActivity.this,"Passwords not Matching", Toast.LENGTH_LONG).show(); 
				  }
				  }
			}
						
			
		});
		 
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,country);
		sp.setAdapter(adapter);
		sp.setOnItemSelectedListener(new OnItemSelectedListener() 
		{

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) 
					
			{
				// TODO Auto-generated method stub
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) 
			{
				// TODO Auto-generated method stub
				 Toast.makeText(MainActivity.this,"Select your country", Toast.LENGTH_LONG).show(); 
			}
			});
		
		r1.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean isChecked) 
			{
				// TODO Auto-generated method stub
				if(isChecked)
				{
				r2.setChecked(false);
				}
			}
		});
		r2.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean isChecked) 
			{
				// TODO Auto-generated method stub
				if(isChecked)
				{
				r1.setChecked(false);
				}
				
			}
		});
		
		
		}
	

		// validating Name
		public boolean isValidName(String name) 
		{
			if (name != null && name.length() > 0) 
			{
				return true;
			}
			return false;
		}
		// validating email id
		public boolean isValidEmail(String email) 
		{
			String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			Pattern pattern = Pattern.compile(EMAIL_PATTERN);
			Matcher matcher = pattern.matcher(email);
			return matcher.matches();
	    }
		//Validating  Mobile Number
		public boolean isValidMobileNumber(String mobno) 
		{
			/**Phone Number formats: (nnn)nnn-nnnn; nnnnnnnnnn; nnn-nnn-nnnn 
		    ^\\(? : May start with an option "(" . 
		    (\\d{3}): Followed by 3 digits. 
		    \\)? : May have an optional ")"  
		    [- ]? : May have an optional "-" after the first 3 digits or after optional ) character.  
		    (\\d{3}) : Followed by 3 digits.  
		     [- ]? : May have another optional "-" after numeric digits. 
		     (\\d{4})$ : ends with four digits. 

		         Examples: Matches following phone numbers: 
		         (123)456-7890, 123-456-7890, 1234567890, (123)-456-7890 **/
		
			String MOBILENUMBER_PATTERN = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";  
			Pattern patternm = Pattern.compile(MOBILENUMBER_PATTERN );
			Matcher matcherm = patternm.matcher(mobno);
			return matcherm.matches();
	    }
		
	public boolean isValidPassword(String enterpassword)
	{
		// TODO Auto-generated method stub
					/**
					  (			# Start of group
			  	(?=.*\d)		#   must contains one digit from 0-9
			  (?=.*[a-z])		#   must contains one lowercase characters
			  (?=.*[A-Z])		#   must contains one uppercase characters
			  (?=.*[@#$%])		#   must contains one special symbols in the list "@#$%"
			             .		#   match anything with previous condition checking
			       {6,20}       #   length at least 6 characters and maximum of 20	
						)		#   End of group
					 */
		//String PASSWORD_PATTERN="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
		String PASSWORD_PATTERN="((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%]).{8,40})";
		Pattern patternp=Pattern.compile(PASSWORD_PATTERN);
		Matcher matcherp=patternp.matcher(enterpassword);
		return matcherp.matches();
	}

	}

