class Solution {
    public String sortVowels(String s) {
        int a = 0, e = 0, i = 0, o = 0, u = 0;

        for(int k=0;k<s.length();k++){
            char ch = s.charAt(k);
            if(ch=='a') a++;
            else if(ch=='e') e++;
            else if(ch=='i') i++;
            else if(ch=='o') o++;
            else if(ch=='u') u++;
        }

        int fa = -1, fe = -1, fi = -1, fo = -1, fu = -1;

        for(int k=0;k<s.length();k++){
            char ch = s.charAt(k);
            if(ch=='a' && fa==-1) fa = k;
            else if(ch=='e' && fe==-1) fe = k;
            else if(ch=='i' && fi==-1) fi = k;
            else if(ch=='o' && fo==-1) fo = k;
            else if(ch=='u' && fu==-1) fu = k;
        }

        StringBuilder vowelOrder = new StringBuilder();

        for(int t=0;t<5;t++){
            if(a>0 && (a>e || (a==e && fa<fe)) && (a>i || (a==i && fa<fi)) && (a>o || (a==o && fa<fo)) && (a>u || (a==u && fa<fu))){
                while(a-- > 0) vowelOrder.append('a');
            }
            else if(e>0 && (e>a || (e==a && fe<fa)) && (e>i || (e==i && fe<fi)) && (e>o || (e==o && fe<fo)) && (e>u || (e==u && fe<fu))){
                while(e-- > 0) vowelOrder.append('e');
            }
            else if(i>0 && (i>a || (i==a && fi<fa)) && (i>e || (i==e && fi<fe)) && (i>o || (i==o && fi<fo)) && (i>u || (i==u && fi<fu))){
                while(i-- > 0) vowelOrder.append('i');
            }
            else if(o>0 && (o>a || (o==a && fo<fa)) && (o>e || (o==e && fo<fe)) && (o>i || (o==i && fo<fi)) && (o>u || (o==u && fo<fu))){
                while(o-- > 0) vowelOrder.append('o');
            }
            else if(u>0){
                while(u-- > 0) vowelOrder.append('u');
            }
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;

        for(int k=0;k<s.length();k++){
            char ch = s.charAt(k);

            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                sb.append(vowelOrder.charAt(idx));
                idx++;
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}