@Action(value="/f",results={@Result(name="success",type="json")})
public String f(){
list1=this.baseservice.find(Zinfo.class);
for(int i=0;i<list1.size();i++){
String b=list1.get(i).getZmc();
a.add(b);
}
return SUCCESS;
}

//获得二级数据源
@Action(value="/f1",results={@Result(name="success",type="json")})
public String f1(){
if(zmc!=null){

//通过zmc查找CId
String[] keys=new String[1];
keys[0]="zmc";
Object[] values=new Object[1];
values[0]=zmc;
List<Integer> CId=this.baseservice.find(Integer.class, "Zinfo", "id.CId", keys, values);
for(int j=0;j<CId.size();j++){
String[] keys1 = {"c_id"};
Object[] values1 = {CId.get(j)};
list2=this.baseservice.find(Kcxx.class, "Kcxx", keys1, values1);
String c = list2.get(0).getCName();
k.add(c);

}
}
return SUCCESS;
}


//获得三级数据源 
@Action(value="/f2",results={@Result(name="success",type="json")})
public String bindZsd(){

if(CName!=null){

//通过CName查找CId
String[] keys=new String[1];
keys[0]="CName";
Object[] values=new Object[1];
values[0]=CName;
List<Integer> CId=this.baseservice.find(Integer.class, "Kcxx", "CId", keys, values);
for(int k=0;k<CId.size();k++){
String[] keys1 = {"c_id"};
Object[] values1 = {CId.get(k)};
list3=this.baseservice.find(Zsd.class, "Zsd", keys1, values1);
String d = list3.get(0).getZsdmc();
s.add(d);
}
}
return SUCCESS;
}

其中定义的变量：
private List<Zinfo> list1;
private List<Kcxx> list2;
private List<Zsd> list3;

private String CName;
private String zmc;
private String zsdmc;

private List<String> a=new ArrayList<String>();
private List<String> k=new ArrayList<String>();
private List<String> s=new ArrayList<String>();
//省略getter、setter方法