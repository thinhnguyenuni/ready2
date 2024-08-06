jQuery(function () {
    $("button[type='reset']").on("click", function () {
    $("span[id*='errors']").text("");
    $("div[class*='error']").text("");
    $(this).closest("form").find("input").removeAttr("value");
  });
  const id = $("#inputID");
  const name = $("#inputName");
  const date = $("#inputDate");
  const errorID = $("#errorID");
  const errorName = $("#errorName");
  const errorDate = $("#errorDate");
  const idRegEx = /^KH\d{5}$/;
 /* const phoneRegEx = /^(090|091|\(84\)\+90|\(84\)\+91)\d{7}$/;
  const emailRegEx = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;*/
   $("#inputForm").on("submit", function (e) {
    e.preventDefault();
    if (
      !validateID(id) |
      !validateName(name) |
      !validateDate(date)	
    ) {
      return;
    }
    this.submit();
  });
 function validateID(selector) {
    const value = selector.val().trim();
    if (value == "") {
      errorID.text("Trường không được để trống");
      return false;
    }
    if (!idRegEx.test(value)) {
      errorID.text("Nhập không đúng định dạng (MMxxx)");
      return false;
    }
    errorID.text("");
    return true;
  }

  function validateName(selector) {
    const value = selector.val().trim();
    if (value == "") {
      errorName.text("Trường không được để trống");
      return false;
    }
    errorName.text("");
    return true;
  }
  function validateDate(selector) {
    const value = selector.val().trim();
    if (value == "") {
      errorDate.text("Trường không được để trống");
      return false;
    }
   const inputDate = new Date(selector.val().trim());
   const currentDate = new Date();
   currentDate.setHours(7, 0, 0, 0);
   if (currentDate<inputDate) {
	  errorDate.text("Ngày không được lớn hơn ngày hiện tại");
      return false;
      }
    errorDate.text("");
    return true;
  }
   
});