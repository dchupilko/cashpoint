public class Currency 
{
    
    // A T T R I B U T E S
    
    // Currency list
    public String _currency = "";
    // Cash divided by 8 values
    public Integer[] _account = new Integer[8];
    // Value of notes
    public Integer[] _value = new Integer[8];
    // Balance, counter and total cash
    public Integer _ext = 0,  _count = 0, _amount = 0;

    // C O N S T R U C T O R S
    
    // Default constructor
    public Currency()
    {

    }
    
    // Constructor with parameters
    public Currency(String currency)
    {
        _currency = currency;
        
        // Initialization of account array
        for (int i = 0; i < 8; i++) 
        {
            _account[i] = 0;
        }
        
        // Filling array with values
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                // Valid values are 10^n and 5*10^n
                _value[i] = (int) Math.pow(10, j);
                _value[i + 1] = 5 * _value[i];
                i+=2;
            }
        }
    }
    
    // M E T H O D S
    
    // Puts notes into cash
    public String AddNotes(Integer value, Integer number) 
    {
        for (int i = 0; i < 8; i++) 
        {
            // Compare input and existing value
            //if (value == _value[i]) 
            if (Integer.parseInt(value.toString())==_value[i])
            {
                // Adding cash to exact value
                _account[i] += number;
                // Calculating total cash
                _amount += _account[i] * _value[i];
                
                // OK if successful
                return "OK";
            }
        }

        // ERROR if validation fails
        return "ERROR";
    }

    // Get the sum from the cash if possible
    public String GetCash(Integer sum) 
    {
        Integer temp = sum;
        
        // Check if the amount is available 
        if (_amount >= sum) 
        {
            // Check if sum can be paid with available values
            for (int i = 7; i >= 0; i--) 
            {
                if (sum != 0 && _account[i] != 0 && _value[i] <= sum) 
                {
                    // How many notes to extract
                    _ext = sum / _value[i];

                    // Calculate the sum left to pay
                    sum -= _value[i] * _ext;
                }
            }
            
            // Get the sum from the cash
            if (sum==0)
            {
                sum = temp;
                
                for (int i = 7; i >= 0; i--) 
                {
                    if (sum != 0 && _account[i] != 0 && _value[i] <= sum) 
                    {
                        // Null the counter and total cash
                        _count = 0;
                        _amount = 0;

                        // How many notes to extract
                        _ext = sum / _value[i];

                        // Extract notes while possible
                        for (int k = 0; k < _ext; k++) 
                        {
                            if (_account[i] > 0) 
                            {
                                _account[i]--;
                                _count++;
                            }
                        }

                        // Print the cash extracted one line per each note value
                        System.out.print(_currency + " " + _value[i] + " " + _count + "\n");

                        // Calculate the sum left to pay
                        sum -= _value[i] * _count;
                    }
                }

//            // Give the change if necessary
//            if (sum > 0) 
//            {
//                for (int i = 7; i >= 0; i--) 
//                {
//                    if (sum != 0 && _value[i] <= sum) 
//                    {
//                        // How much change to add
//                        _ext = sum / _value[i];
//
//                        // Put change into cash
//                        AddNotes(_value[i], _ext);
//                        
//                        // Calculate the change left to add
//                        sum -= _value[i] * _ext;
//                    }
//                }
//            }
            
                // Renew the amount of total cash
                for (int i = 0; i < 8; i++) 
                {
                    _amount += _account[i] * _value[i];
                }

                // Followed with a line OK
                return "OK";
            }
            
            else return "ERROR";
        } 
        
        // If the amount is unavailable
        else return "ERROR";
    }
    
    // Print what is currently in the cash
    public void PrintCash() 
    {
        for (int i = 0; i < 8; i++) 
        {
            if (_account[i] != 0) 
            {
                // Print one line for each currency/value pair which is not null
                System.out.print(_currency + " " + _value[i] + " " + _account[i] + "\n");
            }
        }
    }
        
}