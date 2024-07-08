public class PalindromicString {

    public static void main(String[] args) {
        String s = "vnjwvalrbypfcbqnmopltjnoifmzwgvpzqzsdtvawndpjtpmpjbjionjifqtvvocpeaftvhpdgjjfafunfndztdjkcxyihtsyppendfzzjeyxlbwpdygiqmdqcdbmgyjigrmfkswcwryaydjilqqxvcnyvviesuncslvzikawwqykqwdfibggezufqihcjkebapmgkvwixywgdextafxycnipjglsndkyjoqfyfljfkkvoieksmavdlmlhhnstesibffiopqvlyuidvrawndbzonwzbsjmpeqoglmdbinkovqpzfkxihzitdopnomseqhmrrkcsvrzziphwpuhjngeotwcrebcmbtirkgeavojtmpakcewmexhxacngknokxsvtqobdgckutpexswgwqzbosjpxauyflnylfcxsucsehqvakbpvfmkelmkspsqxnutwfwacpqqvovdqafeylobneojdsgqowcbxfsvuqusdbylcgcvgrofgvzubakjmlbffjhrafvnqttwuyhokzpmhlludpbowuxzrebxsdusalljfjgjkucwzpmndqncykvfnbrxcrcaxwisjpstejjqbpwegpxyrtyafxklgralnkwxkmjpuqfixzkonznmguyizlancpxdzcfkgiotyelegprbaytdhbutbuihkxnbtuqrtezaskfqsmrznfohhlqp";
        String rs = new PalindromicString().longestPalindrome(s);
//        boolean rs = isPalindromic("bb");
        System.out.println(rs);
    }

    public String longestPalindrome(String s) {
        int maxLength = s.length();
        do {
            for (int firstIdx = 0; ; firstIdx++) {
                if(firstIdx+ maxLength > s.length()){
                    break;
                }
                String substring = s.substring(firstIdx, firstIdx + maxLength);
                boolean rs = isPalindromic(substring);
                if (rs) {
                    return substring;
                }
            }
            maxLength--;
        } while (maxLength > 0);
        return "";
    }

    private boolean isPalindromic(String s) {
        if (s.length() == 1) {
            return true;
        }
        int length = s.length();
        for (int i = 0; i <= s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
