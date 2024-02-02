
function loginUser() {

    let id = "test";
    let email = "";
    let password = "";

    let userDto = {
        id : id,
        email : email,
        password: data
    }

    $.ajax({
        url: "/loginUser",
        data: userDto,
        type: 'GET',
        success: function (data) {
            console.log("이미지를 가져왔습니다.");
            console.log(data);
            console.log(data.length);
            console.log(data[0]);
            let ulNode = document.getElementById("gallery");
            let imgText = "";
            for (let i = 0; i < data.length; i++) {
                imgText +=
                    "<div class=\"col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5\">\n" +
                    "                <figure class=\"effect-ming tm-video-item\">\n" +
                    "                    <img src=\"img/img-03.jpg\" alt=\"Image\" class=\"img-fluid\">\n" +
                    "                    <figcaption class=\"d-flex align-items-center justify-content-center\">\n" +
                    "                        <h2>" + data[i].boardNm + "</h2>\n" +
                    "                        <a href=\"photo-detail.html\">View more</a>\n" +
                    "                    </figcaption>                    \n" +
                    "                </figure>\n" +
                    "                <div class=\"d-flex justify-content-between tm-text-gray\">\n" +
                    "                    <span class=\"tm-text-gray-light\">" + data[i].createDt + "</span>\n" +
                    "                    <span>" + data[i].views + " views</span>\n" +
                    "                </div>\n" +
                    "            </div>";
            }
            ulNode.innerHTML = imgText;
        },

        error: function () {
            alert("이미지를 가져오는데 문제가 발생하였습니다.");
        }
    })

}