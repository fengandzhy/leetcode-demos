package org.frank.leetcode.string.integer.to.english.words.demo01;

/**
 * https://leetcode.cn/problems/integer-to-english-words/
 * */
public class IntegerToEnglishWordsSolution1 {

    public String numberToWords(int num) {
        
        StringBuilder stringBuilder = new StringBuilder();
        String billionPart = processNumber(num, DivisorEnums.BILLION);
        String millionPart = processNumber(num % 1000000000, DivisorEnums.MILLION);
        String thousandPart = processNumber(num % 1000000, DivisorEnums.THOUSAND);
        String hundredPart = processHundreds(num % 1000);
        if(!billionPart.isEmpty()){
            stringBuilder.append(billionPart);
        }
        if(!millionPart.isEmpty()){
            addAndJoint(stringBuilder.toString(),stringBuilder);
            stringBuilder.append(millionPart);
        }
        if(!thousandPart.isEmpty()){
            addAndJoint(stringBuilder.toString(),stringBuilder);
            stringBuilder.append(thousandPart);
        }
        if(!hundredPart.isEmpty()){
            addAndJoint(stringBuilder.toString(),stringBuilder);
            stringBuilder.append(hundredPart);
        }
        
        if(num == 0 ){
            return "Zero";
        }
        
        return stringBuilder.toString();
    }

    private String processNumber(int num, DivisorEnums enums) {
        StringBuilder stringBuilder = new StringBuilder();
        int number = num / enums.getDivisor();
        if (number == 0) {
            return stringBuilder.toString();
        }
        String numberStr = processHundreds(number);
        String unit = "";
        switch (enums){
            case BILLION:
                unit = "Billion";
                break;
            case MILLION:
                unit = "Million";
                break;
            case THOUSAND:
                unit = "Thousand";
                break;
            default: break;
        }
        stringBuilder.append(numberStr);
        stringBuilder.append(" ");
        stringBuilder.append(unit);
        return stringBuilder.toString();
    }

    private String processHundreds(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        int hundreds = number / 100;
        int reminder = number % 100;
        if(hundreds == 0){
            return this.processUnitsAndTes(reminder);
        }
        stringBuilder.append(UnitAndTeensEnum.getWord(hundreds));
        stringBuilder.append(" ");
        stringBuilder.append("Hundred");
        String tenAndUnitStr = this.processUnitsAndTes(reminder);
        if(tenAndUnitStr.isEmpty()){
            return stringBuilder.toString();
        }
        stringBuilder.append(" ");
        stringBuilder.append(tenAndUnitStr);
        return stringBuilder.toString();
    }

    private String processUnitsAndTes(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        if (number == 0) {
            return stringBuilder.toString();
        }
        if (number < 20 && number > 0) {
            return UnitAndTeensEnum.getWord(number);
        }
        stringBuilder.append(TensEnum.getWord(number / 10));
        int remainder = number % 10;
        if (remainder != 0) {
            stringBuilder.append(" ").append(UnitAndTeensEnum.getWord(remainder));
        }
        return stringBuilder.toString();
    }

    private void addAndJoint(String dollarStr, StringBuilder stringBuilder){
        if(!dollarStr.isEmpty()){
            stringBuilder.append(" ");
        }
    }

    enum UnitAndTeensEnum {
        ZERO(0,""),
        ONE(1,"One"),
        TWO(2,"Two"),
        THREE(3,"Three"),
        FOUR(4,"Four"),
        FIVE(5,"Five"),
        SIX(6,"Six"),
        SEVEN(7,"Seven"),
        EIGHT(8,"Eight"),
        NINE(9,"Nine"),
        TEN(10,"Ten"),
        ELEVEN(11,"Eleven"),
        TWELVE(12,"Twelve"),
        THIRTEEN(13,"Thirteen"),
        FOURTEEN(14,"Fourteen"),
        FIFTEEN(15,"Fifteen"),
        SIXTEEN(16,"Sixteen"),
        SEVENTEEN(17,"Seventeen"),
        EIGHTEEN(18,"Eighteen"),
        NINETEEN(19,"Nineteen");

        private final int number;
        private final String word;
        UnitAndTeensEnum(int number, String word){
            this.number = number;
            this.word = word;
        }

        public static String getWord(int number) {
            for (UnitAndTeensEnum e : UnitAndTeensEnum.values()) {
                if (e.getNumber() == number) {
                    return e.word;
                }
            }
            return null;
        }

        private int getNumber(){
            return this.number;
        }
    }

    enum TensEnum {
        TWENTY(2,"Twenty"),
        THIRTY(3,"Thirty"),
        FORTY(4,"Forty"),
        FIFTY(5,"Fifty"),
        SIXTY(6,"Sixty"),
        SEVENTY(7,"Seventy"),
        EIGHTY(8,"Eighty"),
        NINETY(9,"Ninety");
        private final int number;
        private final String word;
        TensEnum(int number, String word){
            this.number = number;
            this.word = word;
        }

        public static String getWord(int number) {
            for (TensEnum e : TensEnum.values()) {
                if (e.getNumber() == number) {
                    return e.word;
                }
            }
            return null;
        }

        public int getNumber(){
            return this.number;
        }
    }

    enum DivisorEnums {

        HUNDRED(100),
        THOUSAND(1000),
        MILLION(1000000),
        BILLION(1000000000);

        private final int divisor;

        DivisorEnums(int divisor){
            this.divisor = divisor;
        }

        public int getDivisor() {
            return divisor;
        }
    }
}
