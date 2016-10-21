package Adapter.Adapter3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Евгений on 21.10.2016.
 */
public class Adapter3 {

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

    private static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("Ukraine", "UA");
        countries.put("Russia", "RU");
        countries.put("Canada", "CA");
    }

    public static class DataAdapter implements RowItem {
        Customer customer;
        Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            return countries.get(customer.getCountryName());
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            return contact.getName().split(" ")[1];
        }

        @Override
        public String getContactLastName() {
            return contact.getName().split(", ")[0];
        }

        @Override
        public String getDialString() {
            return "callto://" + contact.getPhoneNumber().replace("(", "").replace(")", "").replace("-", "");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }

    public static void main(String[] args) {
        Contact contact = new Contact() {
            @Override
            public String getName() {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber() {
                return "+38(050)123-45-67";
            }
        };

        Customer customer = new Customer() {
            @Override
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName() {
                return "Ukraine";
            }
        };

        RowItem dataAdapter = new DataAdapter(customer, contact);
        String code = dataAdapter.getCountryCode();             //example UA
        String company = dataAdapter.getCompany();              //example JavaRush Ltd.
        String firstName = dataAdapter.getContactFirstName();   //example Ivan
        String lastName = dataAdapter.getContactLastName();     //example Ivanov
        String phone = dataAdapter.getDialString();             //example callto://+380501234567
    }
}
