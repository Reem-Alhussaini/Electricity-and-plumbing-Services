public class RealServiceAvailability implements ServiceAvailability {
    @Override
    public boolean isServiceAvailable(String serviceType) {

        String employeestatus = ""; // take from database
        if (serviceType.equals("Electrical")){
            if (employeestatus.equals("Available")){
                return true;
            }
            return false;
        }

        else if (serviceType.equals("plummer")){
            if (employeestatus.equals("Available")){
                return true;
            }
            return false;
        }

        else 
            return false;
    }
}