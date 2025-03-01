import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class Calculator {
    public double multiply(double a, double b) {
        return a * b;
    }
    
    public double add(double a, double b) {
        return a + b;
    }
}

class MultiplicationCalculator extends Calculator {
    public MultiplicationCalculator() {
        JFrame frame = new JFrame("social justice Calculator");
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));
        
        JTextField num1Field = new JTextField();
        JTextField num2Field = new JTextField();
        JButton calculateButton = new JButton("calculate social justice");
        JLabel resultLabel = new JLabel("Result: ", SwingConstants.CENTER);
        
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    double result = multiply(num1, num2);
                    
                    if (result == 911) {
                        resultLabel.setText("Dialing 911");
                    } else {
                        resultLabel.setText("Result: " + result);
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input!");
                }
            }
        });
        
        frame.add(num1Field);
        frame.add(num2Field);
        frame.add(calculateButton);
        frame.add(resultLabel);
        
        frame.setVisible(true);
    }
}

class AdditionCalculator extends Calculator {
    public AdditionCalculator() {
        JFrame frame = new JFrame("social justice Calculator");
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));
        
        JTextField num1Field = new JTextField();
        JTextField num2Field = new JTextField();
        JButton calculateButton = new JButton("calculate social justice");
        JLabel resultLabel = new JLabel("Result: ", SwingConstants.CENTER);
        
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    double result = add(num1, num2);
                    
                    resultLabel.setText("Result: " + result);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input!");
                }
            }
        });
        
        frame.add(num1Field);
        frame.add(num2Field);
        frame.add(calculateButton);
        frame.add(resultLabel);
        
        frame.setVisible(true);
    }
}

public class CalculatorMenu {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator Menu");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 1));
        
        JButton multiplicationButton = new JButton("Multiplication");
        JButton additionButton = new JButton("Addition");
        JButton aiButton = new JButton("Advanced AI Chatbot");
        
        multiplicationButton.addActionListener(e -> new MultiplicationCalculator());
        additionButton.addActionListener(e -> new AdditionCalculator());
        aiButton.addActionListener(e -> new AiBot());
        
        frame.add(multiplicationButton);
        frame.add(additionButton);
        frame.add(aiButton);
        
        frame.setVisible(true);
    }
}

class AiBot {
    private Map<String, String> responses;
    
    public AiBot() {
        responses = new HashMap<>();
        responses.put("hello", "Hello! How can I assist you with social justice today?");
        responses.put("social justice", "Social justice refers to the fair and equitable distribution of resources, opportunities, and privileges within a society. It aims to eliminate systemic barriers and discrimination.");
        responses.put("equity", "Equity ensures that everyone receives the support they need to achieve equal outcomes, recognizing that different people have different needs.");
        responses.put("discrimination", "Discrimination is the unfair treatment of individuals based on characteristics such as race, gender, or socioeconomic status. Social justice seeks to eliminate it.");
        responses.put("inclusion", "Inclusion ensures that all individuals, regardless of background, have a voice and representation in society.");
        responses.put("how do i improve social justice", "You can promote social justice through individual actions, community involvement, and policy advocacy.");
        responses.put("how can i improve social justice", "You can promote social justice through individual actions, community involvement, and policy advocacy.");
        responses.put("feminism", "Feminism is a social, political, and intellectual movement advocating for gender equality. It challenges systems of oppression and fights for equal rights, opportunities, and representation for women and marginalized genders.");
        
        JFrame frame = new JFrame("AI ChatBot");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false);
        JTextField inputField = new JTextField();
        JButton sendButton = new JButton("Send");
        
        sendButton.addActionListener(e -> {
            String input = inputField.getText().trim().toLowerCase();
            chatArea.append("You: " + input + "\n");
            
            boolean foundResponse = false;
            for (String key : responses.keySet()) {
                if (input.contains(key)) {
                    chatArea.append("ChatBot: " + responses.get(key) + "\n");
                    foundResponse = true;
                    break;
                }
            }
            
            if (!foundResponse) {
                chatArea.append("ChatBot: Please ask about social justice.\n");
            }
            
            inputField.setText("");
        });
        
        frame.add(new JScrollPane(chatArea), BorderLayout.CENTER);
        frame.add(inputField, BorderLayout.SOUTH);
        frame.add(sendButton, BorderLayout.EAST);
        
        frame.setVisible(true);
    }
}
