package service;

import commands.AccountDepositCommand;
import entity.Account;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {


    @Value("${account.default-ammount}")
    Double defaultMoneyAmount;
    @Value("10")
    Double defaultComission;
    List<Account> accountList;
    List<User> userList;
    UserInputReader userInputReader;

    @Autowired
    public AccountService(List<Account> accountList, UserInputReader userInputReader, List<User> userList) {
        this.accountList = accountList;
        this.userInputReader = userInputReader;
        this.userList = userList;
    }


//    public void createDefaultAccount(User user){
//
//        // Creating default account for him
//        Account account = new Account();
//        account.setId(accountList.size());
//        account.setMoneyAmmount(defaultMoneyAmount);
//        account.setUserId(user.getId());
//        user.setAccounts(account);
//        accountList.add(account);
//
//
//
//    }

    public void createAccount(Integer choosedUserId){

        User user = userList.stream()
                .filter(u -> u.getId().equals(choosedUserId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User with ID " + choosedUserId + " not found"));


        Account account = new Account();
        account.setId(accountList.size());
        account.setMoneyAmmount(defaultMoneyAmount);
        account.setUserId(user.getId());
        user.setAccounts(account);
        accountList.add(account);
        System.out.println("New account created with id: " + account.getId() + " for user: " + user.getLogin());

    }

    public void closeAccount(){

        System.out.println("Enter account ID to close:" );
        Integer accountId = userInputReader.readInt();
        Account accountOfUser = accountList.get(accountId);
        User ownerOfAccount = userList.get(accountOfUser.getUserId());


        if(ownerOfAccount.getAccounts().size() > 1){

            // get count of user's accounts
            Integer countOfUserAccounts = ownerOfAccount.getAccounts().size();
            // take previous user's Account ID;
            Integer previousAccountId = ownerOfAccount.getAccounts().get(0).getId();
            // take money ammount from account that we will delete
//            Double accountMoneyAmmount = ownerOfAccount.getAccounts().get(previousAccountId).getMoneyAmmount();
            // delete account
            Account accountToDelete = ownerOfAccount.getAccounts()
                            .stream()
                            .filter(acc -> acc.getId()
                            .equals(accountId))
                            .findFirst().orElse(null);

//            ownerOfAccount.getAccounts().remove(ownerOfAccount.getAccounts().get(accountId));
            Double deletedAccountMoneyAmmount = accountToDelete.getMoneyAmmount();
            ownerOfAccount.getAccounts().remove(accountToDelete);
            // money from deleted account + previous account
            Double moneyFromBoth = ownerOfAccount.getAccounts().get(previousAccountId).getMoneyAmmount() + deletedAccountMoneyAmmount;
            //
            ownerOfAccount.getAccounts().get(previousAccountId).setMoneyAmmount(moneyFromBoth);

        } else {
            System.out.println("Account ID not found or it's your last account");
        }



    }


    public void depositAccount(){

        System.out.println("Enter account ID: ");
        Integer choosedAccountId = userInputReader.readInt();
        System.out.println("Enter amount to deposit: ");
        Double ammountToDeposit = userInputReader.readDouble();


        Account account = accountList
                .stream()
                .filter(acc -> acc.getId()
                .equals(choosedAccountId))
                .findFirst().orElse(null);

        if (account == null){
            System.out.println("Account with such ID doesn't exist");
        } else {
            account.setMoneyAmmount(account.getMoneyAmmount() + ammountToDeposit);
        }


        System.out.println("Ammount " + ammountToDeposit + " deposited to accpimt ID: " + choosedAccountId);

    }

    public void accountTransfer(){

        System.out.println("Enter source account ID: ");
        Integer sourceId = userInputReader.readInt();
        System.out.println("Enter target account ID: ");
        Integer targetId = userInputReader.readInt();
        System.out.println("Enter amount to transfer");
        Double amountToTransfer = userInputReader.readDouble();

        Account sourceAccount = accountList
                .stream()
                .filter(acc -> acc.getId().equals(sourceId))
                .findFirst().orElse(null);

        Account targetAccount = accountList
                .stream()
                .filter(acc -> acc.getId().equals(targetId))
                .findFirst().orElse(null);

        if (sourceAccount == null || targetAccount == null){
            System.out.println("Such account ID doesn't exist");
        } else if (sourceAccount.getMoneyAmmount() < amountToTransfer) {
            System.out.println("Source account don't have such money amount to transfer, source acount money amount is: " + sourceAccount.getMoneyAmmount());
        } else if (sourceAccount.getUserId() != targetAccount.getUserId()) {
            sourceAccount.setMoneyAmmount(sourceAccount.getMoneyAmmount() - amountToTransfer);
            targetAccount.setMoneyAmmount(targetAccount.getMoneyAmmount() + amountToTransfer - defaultComission);
            System.out.println("Ammount " + (amountToTransfer - defaultComission) + " transfered from account ID " + sourceId + " to account ID " + targetId);

        } else {
            sourceAccount.setMoneyAmmount(sourceAccount.getMoneyAmmount() - amountToTransfer);
            targetAccount.setMoneyAmmount(targetAccount.getMoneyAmmount() + amountToTransfer);
            System.out.println("Ammount " + amountToTransfer + " transfered from account ID " + sourceId + " to account ID " + targetId);
        }

    }

    public void accountWithdraw(){

        System.out.println("Enter account ID to withdraw from: ");
        Integer choosedId = userInputReader.readInt();
        System.out.println("Enter amount to withdraw: ");
        Double amountToWithdraw = userInputReader.readDouble();

        Account account = accountList
                .stream()
                .filter(acc -> acc.getId().equals(choosedId))
                .findFirst().orElse(null);

        if (account == null || account.getMoneyAmmount() < amountToWithdraw){
            System.out.println("Account doesn't exists or don't have such ammount of money");
        } else {
            account.setMoneyAmmount(account.getMoneyAmmount()-amountToWithdraw);
            System.out.println("Amount of " + amountToWithdraw + " was withdraw from account ID " + choosedId);
        }


    }




    public List<User> getUserList() {
        return userList;
    }

    public List<Account> getAccountList() {
        return accountList;
    }
}
