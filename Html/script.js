function ready() {
    alert('DOM is ready');

    // image is not yet loaded (unless was cached), so the size is 0x0
    alert(`Image size: ${img.offsetWidth}x${img.offsetHeight}`);
  }

  //document.addEventListener("DOMContentLoaded", ready);
  
  function display()
  {
      var name = document.getElementsByName("username");
      var password = document.getElementsByName("password");
      var email = document.getElementsByName("emailid");
      var address = document.getElementsByName("address");
      var phone = document.getElementsByName("phoneno");
      var dob = document.getElementsByName("dob");
      var gender = document.getElementsByName("gender");
      var qualifaction = document.getElementsByName("qualification");
      var aathar = document.getElementsByName("aathar");
      var url = document.getElementsByName("url");
      var gen;
      for(i=0;i<gender.length;i++)
      {
        if(gender[i].checked)
        {
            gen = gender[i].value;
        }
      }
      alert("Name : "+name[0].value+"\nPassword : "+password[0].value+"\nEmail : "+email[0].value+"\naddress : "+address[0].value+"\nPhone : "+phone[0].value+"\nDob : "+dob[0].value
      +"\nGender : "+gen+"\nqualiication : "+qualifaction[0].value+"\nAathar : "+aathar[0].value+"\nurl : "+url[0].value);
  }

  function we()
  {
    alert('hi');
    var name = document.getElementsByName("username");
    var password = document.getElementsByName("password");
    var email = document.getElementsByName("emailid");
    var address = document.getElementsByName("address");
    var phone = document.getElementsByName("phoneno");
    var dob = document.getElementsByName("dob");
    var gender = document.getElementsByName("gender");
    var qualifaction = document.getElementsByName("qualification");
    var aathar = document.getElementsByName("aathar");
    var url = document.getElementsByName("url");
    var gen;
    for(i=0;i<gender.length;i++)
    {
      if(gender[i].checked)
      {
          gen = gender[i].value;
      }
    }
    localStorage.setItem("username",name[0].value);
    localStorage.setItem("password",password[0].value);
    localStorage.setItem("emailid",email[0].value);
    localStorage.setItem("address",address[0].value);
    localStorage.setItem("phoneno",phone[0].value);
    localStorage.setItem("dob",dob[0].value);
    localStorage.setItem("gender",gen);
    localStorage.setItem("qualification",qualifaction[0].value);
    localStorage.setItem("aathar",aathar[0].value);
    localStorage.setItem("url",url[0].value);
  }