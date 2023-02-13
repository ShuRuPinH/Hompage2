var mess = ["****", "*****"];
var target = ["text", "ways"];
var style = ["txt", "cursor"]

var pause = 500; // 1500
var speed = 10;  //70
var i = i_str = 0;
var msg = msgpre = msgafter = "";

function get_text() {
    msgpre = mess[i].substring(0, i_str - 1);
    msgafter = mess[i].substring(i_str - 1, i_str);
    msg = "<span class='txt'>" + msgpre + "<span class='cursor'>" + msgafter + "</span></span>";
}

function go() {

    if (i_str <= mess[i].length - 1) {
        i_str++;
        get_text();
        if (document.all) typewriter.innerHTML = msg;
        else if (document.layers) {
            document.typewriter.document.write(msg);
            document.typewriter.document.close();
        } else document.getElementById(target[i]).innerHTML = msg;
        var timer = setTimeout("go()", speed);
    } else {
        clearTimeout(timer);
        var timer = setTimeout("changemess()", pause);
    }
}

function changemess() {
    i++;
    i_str = 0;
    if (i > 1) return;
    go();
}

function setTextAndTarget(txt, ways) {
    if (txt) {
        mess[0] = txt + " ";
    }
    if (ways) {
        mess[1] = ways + " ";
    }
}

/* http://usefulscript.ru/type_writer.php   */
