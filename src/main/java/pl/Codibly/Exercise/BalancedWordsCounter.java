package pl.Codibly.Exercise;

public class BalancedWordsCounter {

    public Integer count(String input){
        if (input == null)
            throw new RuntimeException();

        if (input.length() == 0)
            return 0;

        for (int i = 0; i < input.length(); i++) {
            int codeASCIIOfLetter = (int)(input.charAt(i));
            if (codeASCIIOfLetter > (int)'z' || codeASCIIOfLetter < (int)'a')
                throw new RuntimeException();
        }
        int counter = (input.length() * 2) - 1;

        for (int lengthOfSubstring = 3; lengthOfSubstring < input.length(); lengthOfSubstring++) {
            for (int beginOfSubstring = 0; beginOfSubstring + lengthOfSubstring <= input.length();
                 beginOfSubstring++) {
                if (isBalancedWord(input.substring(beginOfSubstring, beginOfSubstring + lengthOfSubstring)))
                    counter++;
            }
        }
        return counter;
    }

    private boolean isBalancedWord(String substring){
        byte[] substringInAsciiCode = substring.getBytes();
        int counterOfRepeatFirstLetter = 1, firstAsciiCode, counterOfRepeatLetter = 1;
        mergeSort(substringInAsciiCode, substringInAsciiCode.length);
        firstAsciiCode = (int)substringInAsciiCode[0];

        for (int i = 1; i < substring.length(); i++) {
            if (substringInAsciiCode[i] == firstAsciiCode)
                counterOfRepeatFirstLetter++;
        }
        if (counterOfRepeatFirstLetter == substring.length())
            return true;

        for (int i = counterOfRepeatFirstLetter; i < substringInAsciiCode.length; i++) {
            if (i + 1 == substringInAsciiCode.length){
                if (substringInAsciiCode[i] == substringInAsciiCode[i - 1])
                    return counterOfRepeatFirstLetter == counterOfRepeatLetter? true : false;

                if (counterOfRepeatLetter == 0)
                    counterOfRepeatLetter = 1;
                if (counterOfRepeatFirstLetter != counterOfRepeatLetter || counterOfRepeatFirstLetter != 1)
                    return false;
                return true;
            }
            if (substringInAsciiCode[i] == substringInAsciiCode[i + 1]){
                counterOfRepeatLetter++;
            }
            else {
                if (counterOfRepeatFirstLetter != counterOfRepeatLetter)
                    return false;
                counterOfRepeatLetter = 1;
            }
        }
        return true;
    }

    private void mergeSort(byte[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        byte[] l = new byte[mid];
        byte[] r = new byte[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    private void merge(
            byte[] a, byte[] l, byte[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}
