<#ftl auto_esc=false>
<!doctype html>
<html>
<head>
    <meta name="viewport" content="width=device-width">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Simple Transactional Email</title>
    <style>
        @media only screen and (max-width: 620px) {
            table[class=body] h1 {
                font-size: 28px !important;
                margin-bottom: 10px !important;
            }
            table[class=body] p,
            table[class=body] ul,
            table[class=body] ol,
            table[class=body] td,
            table[class=body] span,
            table[class=body] a {
                font-size: 16px !important;
            }
            table[class=body] .wrapper,
            table[class=body] .article {
                padding: 10px !important;
            }
            table[class=body] .content {
                padding: 0 !important;
            }
            table[class=body] .container {
                padding: 0 !important;
                width: 100% !important;
            }
            table[class=body] .main {
                border-left-width: 0 !important;
                border-radius: 0 !important;
                border-right-width: 0 !important;
            }
            table[class=body] .btn table {
                width: 100% !important;
            }
            table[class=body] .btn a {
                width: 100% !important;
            }
            table[class=body] .img-responsive {
                height: auto !important;
                max-width: 100% !important;
                width: auto !important;
            }
        }
        @media all {
            .ExternalClass {
                width: 100%;
            }
            .ExternalClass,
            .ExternalClass p,
            .ExternalClass span,
            .ExternalClass font,
            .ExternalClass td,
            .ExternalClass div {
                line-height: 100%;
            }
            .apple-link a {
                color: inherit !important;
                font-family: inherit !important;
                font-size: inherit !important;
                font-weight: inherit !important;
                line-height: inherit !important;
                text-decoration: none !important;
            }
            .btn-primary table td:hover {
                background-color: #34495e !important;
            }
            .btn-primary a:hover {
                background-color: #34495e !important;
                border-color: #34495e !important;
            }
        }
    </style>
</head>
<body class="" style="background-color: #f6f6f6; font-family: sans-serif; -webkit-font-smoothing: antialiased; font-size: 14px; line-height: 1.4; margin: 0; padding: 0; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;">
<table border="0" cellpadding="0" cellspacing="0" class="body" style="border-collapse: separate; mso-table-lspace: 0pt; mso-table-rspace: 0pt; width: 100%; background-color: #f6f6f6;">
    <tr>
        <td style="font-family: sans-serif; font-size: 14px; vertical-align: top;">&nbsp;</td>
        <td class="container" style="font-family: sans-serif; font-size: 14px; vertical-align: top; display: block; Margin: 0 auto; max-width: 640px; padding: 10px; width: 640px;">
            <div class="content" style="box-sizing: border-box; display: block; Margin: 0 auto; max-width: 640px; padding: 10px;">

                <!-- START CENTERED WHITE CONTAINER -->
                <span class="preheader" style="color: transparent; display: none; height: 0; max-height: 0; max-width: 0; opacity: 0; overflow: hidden; mso-hide: all; visibility: hidden; width: 0;">Это важная информация для вас действительна три дня</span>
                <table class="main" style="border-collapse: separate; mso-table-lspace: 0pt; mso-table-rspace: 0pt; width: 100%; background: #ffffff; border-radius: 3px;">

                    <!-- START MAIN CONTENT AREA -->
                    <tr>
                        <td class="wrapper" style="font-family: sans-serif; font-size: 14px; vertical-align: top; box-sizing: border-box; padding: 20px;">
                            <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: separate; mso-table-lspace: 0pt; mso-table-rspace: 0pt; width: 100%;">
                                <tr>
                                    <td style="font-family: sans-serif; font-size: 14px; vertical-align: top;">
                                        <h1 style="padding: 30px 10px; background-color: #0D47A1; font-size: 22px; color: #EAF2F8">
                                            Европейская Школа Корреспондентского Обучения
                                        </h1>

                                        <p style="font-family: sans-serif; font-size: 14px; font-weight: normal; margin: 0; Margin-bottom: 15px;">
                                            Здраствуйте, ${clientName}.<br>
                                            Наша команда постоянно работает над тем, чтобы сделать курсы ЕШКО еще более доступными для наших студентов.
                                            Поэтому к началу учебного года мы подготовили для Вас специальное предложение:
                                            бесплатное обучение на курсе "${itemName}" в pdf версии.
                                            Вы оплачиваете только регистрационный взнос ${totalPrice} бел. руб.
                                        </p>
                                        <p style="font-family: sans-serif; font-size: 14px; font-weight: normal; margin: 0; Margin-bottom: 15px;">
                                            Это письмо расскажет вам как получить доступ к электронным материалам (1-20 уроки) курса ${itemName}.
                                        </p>
                                        <p style="font-family: sans-serif; font-size: 14px; font-weight: normal; margin: 0; Margin-bottom: 15px;">
                                            Обращаем Ваше внимание на то, что предоставленные учебные материалы ЕШКО:
                                            методические материалы для обучающихся на корреспондентских курсах, учебные журналы, аудиоматериалы (далее - учебные материалы),
                                            предоставляемые Вам Иностранным унитарным образовательным предприятием «ЕШКО»,
                                            являются объектом авторского права и охраняются Законом Республики Беларусь от 17 мая 2011 г. № 262-З «Об авторском праве и смежных правах».
                                            Оплачивая регистрационный взнос и получая доступ к Учебным материалам Вы даете обязательство на нераспространение их третьим лицам.
                                        </p>
                                        <h2>Инструкция по оплате</h2>
                                        <p style="font-family: sans-serif; font-size: 14px; font-weight: normal; margin: 0; Margin-bottom: 15px;">
                                            Для оплаты с помощью системы «Расчет» необходимо:
                                        <ul>
                                            <li>обратиться в пункт обслуживания системы «Расчет»: отделение банка, сайт банка с функцией Интернет-банкинга, терминал и т.д.;</li>
                                            <li>выбрать в дереве ЕРИП:</li>
                                            <li style="margin-left: 50px; list-style: square outside;">«Общереспубликанские»</li>
                                            <li style="margin-left: 50px; list-style: square outside;">далее «Образование и развитие»</li>
                                            <li style="margin-left: 50px; list-style: square outside;">далее "Дополнительное образование и развитие"</li>
                                            <li style="margin-left: 50px; list-style: square outside;">далее "Дистанционное обучение"</li>
                                            <li style="margin-left: 50px; list-style: square outside;">далее «ЕШКО дистанционные курсы»;</li>
                                            <li style="margin-left: 50px; list-style: square outside;">указать Ваш номер клиента ${clientId}.</li>
                                            <li style="margin-left: 50px; list-style: square outside;">в графе название курса указать  «регистрационный взнос»;</li>
                                            <li style="margin-left: 50px; list-style: square outside;">указать сумму оплаты ${totalPrice};</li>
                                            <li>проверить информацию и произвести оплату.</li>
                                        </ul>
                                        </p>
                                        <h2>Доступ к урокам</h2>
                                        <p style="font-family: sans-serif; font-size: 14px; font-weight: normal; margin: 0; Margin-bottom: 15px;">
                                            Доступ к PDF версии курса и аудио приложению в МР3 формате будет открыт в
                                            Вашем личном кабинете после поступления оплаты (оплата поступает в течение 1-3 банковских рабочих дней).
                                        </p>
                                        <p style="font-family: sans-serif; font-size: 14px; font-weight: normal; margin: 0; Margin-bottom: 15px;">
                                            После того, как поступит оплата, на указанный Вами e-mail будет отправлена инструкция
                                            для дальнейшей регистрации.
                                        </p>
                                        <p style="font-family: sans-serif; font-size: 14px; font-weight: normal; margin: 0; Margin-bottom: 15px;">
                                            После регистрации, Вы сможете скачать уроки из своего кабинета студента,
                                            загрузить их на компьютер, планшет, мобильный телефон или любое другое устройство поддерживающие PDF файлы.
                                            Уроки можно читать как электронную книгу или распечатать для себя (как Вам удобнее).
                                        </p>
                                        <p style="font-family: sans-serif; font-size: 14px; font-weight: normal; margin: 0; Margin-bottom: 15px;">
                                            Уроки включают в себя множество упражнений, домашние задания и практикумы.
                                            Ключи к заданиям приведены в конце урока. Выполнение домашних заданий имеет рекомендуемый характер.
                                            Также вы сможете принять участие в вебинарах, проводимых преподавателями ЕШКО.
                                        </p>
                                        <h2>Технические характеристики файлов для скачивания</h2>
                                        <p style="font-family: sans-serif; font-size: 14px; font-weight: normal; margin: 0; Margin-bottom: 15px;">
                                            Журналы с уроками представлены в формате PDF, аналогично нашим пробным урокам в электронном виде.
                                            Файлы открываются при помощи программы Reader Acrobat. Эту программу можно скачать бесплатно с сайта компании Adobe.
                                            Аудио файлы к этим урокам прилагаются, как обычно, в формате МР3 и заархивированы
                                            в ZIP (ЗИП) архив объемом около 500 Мегабайт.
                                            Время скачивания, в зависимости от скорости Интернет и вида носителя (компьютер, телефон, планшет), может составить до 30 минут.
                                        </p>

                                        <p style="font-family: sans-serif; font-size: 14px; font-weight: normal; margin: 0; Margin-bottom: 15px;">
                                            С уважением, специалист по работе с клиентами<br>
                                        ${userName}.<br>
                                            +375173453330<br>
                                            +375296910330 (Velcom)<br>
                                            +375336910330 (MTC)<br>
                                        </p>

                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>

                    <!-- END MAIN CONTENT AREA -->
                </table>

                <!-- START FOOTER -->
                <div class="footer" style="clear: both; Margin-top: 10px; text-align: center; width: 100%;">
                    <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: separate; mso-table-lspace: 0pt; mso-table-rspace: 0pt; width: 100%;">
                        <tr>
                            <td class="content-block" style="font-family: sans-serif; vertical-align: top; padding-bottom: 10px; padding-top: 10px; font-size: 12px; color: #999999; text-align: center;">
                                <span class="apple-link" style="color: #999999; font-size: 12px; text-align: center;">
                                    Иностранное унитарное образовательное предприятие «ЕШКО», УНП 101491292, Республика Беларусь, 220118, г. Минск, ул. Шишкина, 32, пом.8,
                                </span>
                            </td>
                        </tr>
                        <tr>
                            <td class="content-block powered-by" style="font-family: sans-serif; vertical-align: top; padding-bottom: 10px; padding-top: 10px; font-size: 12px; color: #999999; text-align: center;">
                                <a href="http://www.eshko.by/" target="_blank" style="text-decoration: underline; color: #999999; font-size: 12px; text-align: center;">eshko.by</a>.
                            </td>
                        </tr>
                    </table>
                </div>
                <!-- END FOOTER -->

                <!-- END CENTERED WHITE CONTAINER -->
            </div>
        </td>
        <td style="font-family: sans-serif; font-size: 14px; vertical-align: top;">&nbsp;</td>
    </tr>
</table>
</body>
</html>