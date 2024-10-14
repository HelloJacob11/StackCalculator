package com.example.test;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label insert;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        Parent scene = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(scene,640,400));
        stage.show();

    }

    @FXML
    protected void onHelloButtonClick1() throws IOException {
       welcomeText.setText("new Scene");

    }
    public String complexCalculation(String value){
        System.out.println(value);
        ArrayList<String> first=new ArrayList<String>();
        ArrayList<String> stack = new ArrayList<String>();
        String low[]={"+","-"};
        String high[]={"*","/"};
        String temp= "";
        for (int i=0;i<value.length();i++){
            if ((value.charAt(i) == '+')||(value.charAt(i) == '-')||(value.charAt(i) == '*')||(value.charAt(i) == '/')){
                first.add(temp);
                if (stack.size()==0){
                    stack.add(value.substring(i,i+1));
                }
                //stack에 부호의 크기 비교를 하고 stack이나 first에 값을 추가/빼기를 한다.
                else{
                    HashMap<Character,Integer> op = new HashMap<>(){{put('+',1);put('-',1);put('*',2);put('/',2);}};
                    int order = op.get(value.charAt(i));
                    while (stack.size() > 0 && op.get(stack.get(stack.size()-1).charAt(0)) >= order){
                        first.add(stack.get(stack.size()-1));
                        stack.remove(stack.size()-1);
                    }
                    stack.add(value.substring(i,i+1));

                }
                temp="";
            }
            else{
                temp += value.charAt(i);
            }

        }
        System.out.println(first + ", " +stack);
        if (!temp.equals(""))
            first.add(temp);
        int size = stack.size();
        for(int j=size-1;j>-1;j--){
            first.add(stack.get(j));
            stack.remove(j);
        }


        //계산
        for (int i=0;i<first.size();i++){
            double t = 0;
            if (first.get(i).charAt(0)>='0' && first.get(i).charAt(0)<='9'){
                stack.add(first.get(i));
            }
            else{
                if (first.get(i).equals("+")){
                    t=Double.parseDouble(stack.get(stack.size()-1))+Double.parseDouble(stack.get(stack.size()-2));
                    stack.remove(stack.size()-1);
                    stack.remove(stack.size()-1);
                }
                else if (first.get(i).equals("-")){
                    t=Double.parseDouble(stack.get(stack.size()-2)) - Double.parseDouble(stack.get(stack.size()-1));
                    stack.remove(stack.size()-1);
                    stack.remove(stack.size()-1);
                }
                else if (first.get(i).equals("*")){
                    t=Double.parseDouble(stack.get(stack.size()-1))*Double.parseDouble(stack.get(stack.size()-2));
                    stack.remove(stack.size()-1);
                    stack.remove(stack.size()-1);
                }
                else if (first.get(i).equals("/")){
                    t=Double.parseDouble(stack.get(stack.size()-2))/Double.parseDouble(stack.get(stack.size()-1));
                    stack.remove(stack.size()-1);
                    stack.remove(stack.size()-1);
                }
                stack.add(Double.toString(t));
            }

            System.out.println(stack);
        }
        return stack.get(0);
    }

    @FXML
    protected void onClick1(){
        insert.setText(insert.getText() + "1");
    }
    @FXML
    protected void onClick2(){
        insert.setText(insert.getText()+"2");
    }
    @FXML
    protected void onClick3(){
        insert.setText(insert.getText()+"3");
    }
    @FXML
    protected void onClick4(){
        insert.setText(insert.getText()+"4");
    }
    @FXML
    protected void onClick5() {
        insert.setText(insert.getText() + "5");
    }
    @FXML
    protected void onClick6(){
        insert.setText(insert.getText()+"6");
    }
    @FXML
    protected void onClick7(){
        insert.setText(insert.getText()+"7");
    }
    @FXML
    protected void onClick8(){
        insert.setText(insert.getText()+"8");
    }
    @FXML
    protected void onClick9(){
        insert.setText(insert.getText()+"9");
    }
    @FXML
    protected void onClickAdd() {
        String c = insert.getText();
        if (c.charAt(c.length()-1) >= '0' && c.charAt(c.length()-1) <= '9')
            insert.setText(insert.getText() + "+");
    }
    @FXML
    protected void onClickSubtract() {
        String c = insert.getText();
        if (c.charAt(c.length()-1) >= '0' && c.charAt(c.length()-1) <= '9')
            insert.setText(insert.getText() + "-");
    }
    @FXML
    protected void onClickMultiply() {
        String c = insert.getText();
        if (c.charAt(c.length()-1) >= '0' && c.charAt(c.length()-1) <= '9')
            insert.setText(insert.getText() + "*");
    }
    @FXML
    protected void onClickDivide() {
        String c = insert.getText();
        if (c.charAt(c.length()-1) >= '0' && c.charAt(c.length()-1) <= '9')
            insert.setText(insert.getText() + "/");
    }
    @FXML
    protected void onClickEquals() {
        String c=insert.getText();
        if (!((c.charAt(c.length()-1)>='0') && (c.charAt(c.length()-1) <='9'))){
            insert.setText(complexCalculation(c.substring(0,c.length()-1)) + c.charAt(c.length()-1));
        }
        else insert.setText(complexCalculation(c));
    }

    @FXML
    protected void onClickDelete() {
        insert.setText(insert.getText().substring(0,insert.getText().length()-1));
    }
    @FXML
    protected void onClickReset() {
        insert.setText("");
    }



}