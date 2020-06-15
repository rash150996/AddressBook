/*Making class PersonInfo for using as a data type in arraylist*/

import java.util.*;
import javax.swing.*;
class PersonInfo{

  			String name;
			String address;
   		String phoneNum;
			String zipcode;

			//Constructor

   		public PersonInfo(String n, String add, String phone, String zip_code)
			{

				name = n;
				address = add;
				phoneNum = phone;
				zipcode=zip_code;//follow namming conventiaon fo variable names
  			}  // PersonInfo constructor

			public void print()
			{

				JOptionPane.showMessageDialog(null, "Name: " +name+"\nAddress: " +address+"\nZip Code: "+zipcode+ "\nPhone No.: "+ phoneNum,
														 "Address Book", JOptionPane.PLAIN_MESSAGE);
  			}

         public void pprint(String operation)
         {

            JOptionPane.showMessageDialog(null, "Successfully "+operation);
         }


}

class AddressDetails
{
			ArrayList<PersonInfo> persons;
			ArrayList<PersonInfo> details;

			//constructor
			public AddressDetails ( ) 
			{
            persons = new ArrayList<PersonInfo>();
				details = new ArrayList<PersonInfo>();
			}

			//add new person record to arraylist after taking input
        	public void addPerson( ) 
			{

				String name = JOptionPane.showInputDialog("Enter name");
				String add = JOptionPane.showInputDialog("Enter address");
				String pNum = JOptionPane.showInputDialog("Enter phone no");
				String zCode = JOptionPane.showInputDialog("Enter zip code");

          	//construct new person object
				PersonInfo p = new PersonInfo(name, add, pNum, zCode);

      		//add the above PersonInfo object to arraylist
				persons.add(p);
				p.pprint("added");
       	}

			public void search(String name)
			{
				int count = 0;
				for(int i = 0; i < persons.size(); i++)
				{
					PersonInfo p = (PersonInfo)persons.get(i);
					if(name.equals(p.name))
					{
						p.print();
						count+=1;
					}
				}
				if(count==0)
					JOptionPane.showMessageDialog(null, "Name does not exist","Alert",JOptionPane.WARNING_MESSAGE);

			}

			public void remove(String name)
			{
				int count = 0;
				for(int i = 0; i < persons.size(); i++)
				{
					PersonInfo p = (PersonInfo)persons.get(i); 
					if(name.equals(p.name))
					{
						persons.remove(i);
						count+=1;
						p.pprint("removed");
					}
				}
				if(count==0)
					JOptionPane.showMessageDialog(null,"Name does not exist","Alert",JOptionPane.WARNING_MESSAGE);
			}

			public void show()
			{
				int count = 0;
				for(int i=0; i< persons.size(); i++)
            {
					PersonInfo p = (PersonInfo)persons.get(i);
					p.print();
					count+=1;
				}
				if(count==0)
					JOptionPane.showMessageDialog(null,"AddressBook is empty","Alert",JOptionPane.WARNING_MESSAGE);
			}


}


public class AddressBook
{

			public static void main(String args[]){
			AddressDetails add = new AddressDetails();
			int ch;
 			String name;

			while(true)
			{
 				name = JOptionPane.showInputDialog("Enter 1 to add\nEnter 2 to search\nEnter 3 to remove\nEnter 4 to display Address Book");
     			ch = Integer.parseInt(name); //converting String to character
      		switch(ch){
         		case 1:
						add.addPerson();
						break;
         		case 2:
                	name = JOptionPane.showInputDialog("Enter The Name");
                	add.search(name);
                	break;
         		case 3:
						name = JOptionPane.showInputDialog("Enter The Name");
						add.remove(name);
					case 4:
						add.show();
						break;
         		case 5:
						System.exit(0);
       }//statment
      }//while
   }
 }

