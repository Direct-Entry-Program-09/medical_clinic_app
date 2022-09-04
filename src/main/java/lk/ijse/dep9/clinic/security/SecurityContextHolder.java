package lk.ijse.dep9.clinic.security;

public class SecurityContextHolder {
private static User user;

public static User getPrincipal(){
    if (user==null){
        throw new RuntimeException("No Authenticated User");
    }
    return user;
}
    // why do we create set principal method here is that really needed?
    // that is due to code reusability. Imagine if a new developer came and he set it to enter a user with null s then to avoid that here we set
    public static void setPrincipal(User user){  // shadowing

        if (user== null){
            throw new NullPointerException("Principle can't be null");
        } else if (user.getUsername()==null || user.getUsername().isBlank()||user.getRole()==null) {
            throw new RuntimeException("Invalid User");
        }
        SecurityContextHolder.user=user; // to access the user in the Security Context Holder here we experience shadowing
    }

    public void clear(){
        user=null;// in here also we access the user inside the security context holder

    }
}
