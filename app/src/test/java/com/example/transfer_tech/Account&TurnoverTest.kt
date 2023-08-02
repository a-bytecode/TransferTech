package com.example.transfer_tech

import android.os.Build
import com.example.transferTech.remote.TransferTechApiService
import org.junit.Assert.*
import remote.Repository
import androidx.test.ext.junit.runners.AndroidJUnit4
import bankacc.TurnoverAcc
import kotlinx.coroutines.runBlocking
import kredit.BankAcc
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.robolectric.annotation.Config
import remote.TurnoverApiService

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.Q])
class FuncTests {

    private var accountApi = TransferTechApiService.UserApi
    private var turnoverApi = TurnoverApiService.UserApi

    private lateinit var repository: Repository

    // ***** UnitTest für getAccounts ***** //

    suspend fun getAccounts() : List<BankAcc> {

        repository = Repository(accountApi,turnoverApi)

        return accountApi.retrofitService.getServerResponseBankAcc()
    }

    @Test
    fun getAccountsTest() = runBlocking{

        val accounts = listOf(
            BankAcc(
                0,
                "Zizzle Kredit",
                "Marcy",
                "Keith",
                "203467076.55",
                "€",
                "DE13530942428941855348756310"
            ),
            BankAcc(
                1,
                "Utarian Kredit",
                "Cabrera",
                "Terry",
                "100392.05",
                "$",
                "DE75032031245244903731529334"
            ),
            BankAcc(
                2,
                "Daycore Depot",
                "Wilcox",
                "Hendrix",
                "1202.57",
                "€",
                "DE24193391086374847211003067"
            ),
            BankAcc(
                3,
                "Imperium Kredit",
                "Paula",
                "Erickson",
                "-2545.75",
                "€",
                "DE17639860489418373524724268"
            ),
            BankAcc(
                4,
                "Xelegyl Depot",
                "Mckinney",
                "Cherry",
                "1934875130.94",
                "¥",
                "DE79393819988111778189456949"
            )
        )

        assertEquals(getAccounts(),accounts)
    }

    // ***** UnitTest für getTurnover ***** //

    suspend fun getTurnovers(accID: String) :  List<TurnoverAcc> {

        repository = Repository(accountApi,turnoverApi)

        return turnoverApi.retrofitService.getTurnovers(accID)
    }

    @Test
    fun getTurnoverTest() = runBlocking {

        val turnoverAccounts1 :  List<TurnoverAcc> =  listOf(
            TurnoverAcc(
                id = "64c389ec32fb4ad195cdb70d",
                account_id = 2,
                amount = 6296.11,
                sender_name = "Noralex",
                sender_iban = "DE90576089532081251049776657",
                reference = "Tempor amet pariatur reprehenderit incididunt ea ut officia nostrud voluptate. Culpa fugiat quis ea ullamco cupidatat fugiat officia Lorem ea ipsum. Aute aute elit labore deserunt incididunt consectetur ut Lorem eiusmod minim. Laborum in ullamco est do aliqua fugiat qui sit aliqua.",
                date = "Thu Jul 31 1986 02:41:48 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec5f326730ffc99c38",
                account_id = 2,
                amount = 9644.22,
                sender_name = "Zytrek",
                sender_iban = "DE36188987963884423811538067",
                reference = "Ut tempor qui qui cupidatat Lorem elit culpa elit duis in in pariatur nulla. Ullamco labore consectetur aliqua adipisicing officia consequat culpa ea ea ad ut consequat dolore. Id magna incididunt aliqua deserunt duis Lorem do voluptate reprehenderit. Adipisicing eiusmod non non enim eiusmod elit amet. Culpa sunt est ipsum nisi esse.",
                date = "Sun Mar 23 1975 15:56:30 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec798181117247658f",
                account_id = 2,
                amount = 420.15,
                sender_name = "Zidox",
                sender_iban = "DE54198681876469539413041792",
                reference = "Tempor dolore cupidatat proident tempor ullamco labore velit. Eiusmod elit in consectetur mollit cupidatat non labore minim amet deserunt pariatur do irure amet. Ea qui eu veniam minim consequat adipisicing incididunt et ullamco laborum aute esse do sit.",
                date = "Mon Mar 16 1981 09:41:42 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec4f84088a24a13313",
                account_id = 2,
                amount = 5742.53,
                sender_name = "Comtrail",
                sender_iban = "DE19413135655362069139525981",
                reference = "Consequat ipsum quis sunt dolor et. Consequat laboris consequat ut exercitation laborum eu sit ipsum. Exercitation aliquip pariatur in velit culpa ullamco est nulla est. In cillum ea excepteur nisi veniam.",
                date = "Tue Sep 12 1995 08:14:07 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ece515ec482c0c59dd",
                account_id = 2,
                amount = 3860.35,
                sender_name = "Andryx",
                sender_iban = "DE12702745739793500645958376",
                reference = "Irure consequat velit Lorem excepteur anim proident nostrud nulla laborum cillum.",
                date = "Fri Dec 04 1992 21:43:46 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389eccf6b900ff942927c",
                account_id = 2,
                amount = 2209.71,
                sender_name = "Prosure",
                sender_iban = "DE11429536411832551554925579",
                reference = "Id ex nulla nulla sunt eiusmod quis proident adipisicing et dolor amet consequat mollit enim. Occaecat id anim sit esse nisi fugiat commodo deserunt mollit consectetur eu. Voluptate enim dolore pariatur est anim. Nostrud adipisicing sint fugiat tempor duis excepteur magna duis labore. Lorem consequat irure labore est in do laboris dolore.",
                date = "Mon Jun 05 1995 10:36:00 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec1a6e6d253eac6931",
                account_id = 2,
                amount = 2861.91,
                sender_name = "Tersanki",
                sender_iban = "DE40001569838413364558839574",
                reference = "Eiusmod est ex ex Lorem elit ullamco officia nostrud est. Deserunt Lorem sint officia dolore elit. Labore esse adipisicing eiusmod fugiat enim voluptate qui sit qui pariatur mollit minim excepteur.",
                date = "Fri Sep 17 1982 07:12:52 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec9c8f29f7da67038f",
                account_id = 2,
                amount = 6878.89,
                sender_name = "Acusage",
                sender_iban = "DE49591931308526148295548234",
                reference = "Cillum sint veniam dolor labore in aute dolor Lorem. Est anim cillum aute amet laborum eiusmod aliqua in tempor minim voluptate nulla eu.",
                date = "Sun May 12 1985 16:33:03 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec033b18cc64d1b07e",
                account_id = 2,
                amount = 771.3,
                sender_name = "Splinx",
                sender_iban = "DE65722720398255035491439790",
                reference = "Sunt ea ut velit aliqua sunt occaecat ullamco culpa sit. Tempor nostrud adipisicing ullamco Lorem laborum occaecat consequat ex. Nulla magna enim proident ipsum tempor.",
                date = "Sun Apr 27 2003 15:33:25 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec718cd29588ab6b32",
                account_id = 2,
                amount = 1623.08,
                sender_name = "Omnigog",
                sender_iban = "DE42339907779543052956490289",
                reference = "Ea esse minim ex do culpa in nostrud elit adipisicing esse veniam. Officia velit duis mollit labore minim deserunt non elit voluptate ullamco quis nostrud voluptate. Id exercitation cillum nulla aliqua reprehenderit reprehenderit consequat aliqua incididunt.",
                date = "Sun Jan 25 2004 16:03:00 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec36446f81bacacc40",
                account_id = 2,
                amount = 6432.11,
                sender_name = "Magnafone",
                sender_iban = "DE56324449620126894371330312",
                reference = "Laboris eiusmod non irure proident. Commodo duis ipsum esse ea culpa aute elit enim aute ipsum culpa.",
                date = "Sun Apr 11 1993 06:24:07 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec0fd9affbc74a06c4",
                account_id = 2,
                amount = 4086.29,
                sender_name = "Sureplex",
                sender_iban = "DE46726382843343251165190598",
                reference = "Veniam duis voluptate veniam cillum ea cupidatat cillum quis. Reprehenderit et consectetur consectetur in labore.",
                date = "Wed Nov 04 1998 14:34:35 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec07cb3a6b277b0220",
                account_id = 2,
                amount = 2523.01,
                sender_name = "Cyclonica",
                sender_iban = "DE44286701366641353114039224",
                reference = "Velit nisi culpa anim amet in pariatur et consectetur duis magna sit anim occaecat. Culpa aliqua magna deserunt dolore nisi voluptate eu aute proident qui incididunt occaecat nostrud incididunt. Irure enim tempor dolore dolore quis id cupidatat ea officia aliqua id sint adipisicing aliqua. Do sit ad sunt labore qui nostrud esse labore tempor. Consequat officia magna exercitation ut et mollit labore deserunt elit dolore nulla eiusmod.",
                date = "Wed Aug 21 1996 23:44:01 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecdf09e84bda4e892e",
                account_id = 2,
                amount = 2346.69,
                sender_name = "Ecratic",
                sender_iban = "DE96362489907273065618563424",
                reference = "Dolore consequat commodo consectetur consectetur et officia irure excepteur.",
                date = "Fri Mar 01 2019 07:23:24 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec24e0e569c7e9b8c3",
                account_id = 2,
                amount = 7642.25,
                sender_name = "Comstar",
                sender_iban = "DE97406651276985559384351376",
                reference = "Lorem laborum elit eiusmod cillum exercitation. Commodo ad ea incididunt veniam tempor. Deserunt aute eu quis incididunt eu aute excepteur nisi. Exercitation ea exercitation nisi veniam est ullamco aliqua officia labore qui exercitation fugiat. Reprehenderit in consequat esse eiusmod consectetur.",
                date = "Tue Mar 14 1972 22:04:23 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecb129d89cb949eaae",
                account_id = 2,
                amount = 5889.87,
                sender_name = "Insuron",
                sender_iban = "DE42498561698411871852548722",
                reference = "Duis qui ad mollit exercitation veniam cupidatat labore. Cupidatat eiusmod anim minim proident officia exercitation nostrud minim. Occaecat veniam do eu culpa laboris veniam esse.",
                date = "Tue May 14 1974 01:59:02 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ece3cad742fbdc7822",
                account_id = 2,
                amount = 1348.09,
                sender_name = "Telequiet",
                sender_iban = "DE19960470072175878711576951",
                reference = "Veniam non id ex esse ullamco consectetur est et veniam. Consequat aute dolore eiusmod officia amet ut laboris amet. Deserunt ullamco nostrud id duis do adipisicing anim. Id voluptate consequat nostrud officia labore occaecat deserunt culpa.",
                date = "Mon Jan 19 1970 03:41:15 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecb283e74f506eebea",
                account_id = 2,
                amount = 4129.95,
                sender_name = "Zappix",
                sender_iban = "DE47441220394784864188455297",
                reference = "Cillum esse velit excepteur nisi.",
                date = "Wed Oct 05 1983 04:35:46 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec2f1a88fb41d0fcb2",
                account_id = 2,
                amount = 9233.8,
                sender_name = "Uniworld",
                sender_iban = "DE25070719591219514689056383",
                reference = "Veniam ullamco ut proident excepteur aliquip fugiat dolore. Incididunt pariatur duis quis amet et consequat cupidatat. Fugiat culpa sunt non irure minim commodo commodo velit nisi duis minim est. Tempor ad fugiat quis velit amet qui velit nostrud cupidatat veniam minim esse tempor tempor. Culpa labore officia irure ullamco velit tempor ex ipsum cupidatat commodo dolor cupidatat consectetur excepteur.",
                date = "Mon Mar 20 1972 19:29:49 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec59d7ed640781e771",
                account_id = 2,
                amount = 4100.8,
                sender_name = "Quilk",
                sender_iban = "DE19446696209526955260806014",
                reference = "Ea laboris in sunt esse elit minim officia eu consequat officia laboris minim irure pariatur. Voluptate veniam do sint nisi pariatur id voluptate duis eu est. Aliquip consequat mollit tempor qui cillum dolore ad aliqua sit eu aute. Cillum amet aliqua dolore Lorem eu est ut culpa est.",
                date = "Fri Mar 30 2012 18:17:13 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecfeff58363bbc668c",
                account_id = 2,
                amount = 769.24,
                sender_name = "Zillanet",
                sender_iban = "DE28544351001760081377830471",
                reference = "Nulla mollit aliqua magna cupidatat velit id cupidatat. Reprehenderit est duis non nisi sit exercitation et.",
                date = "Sat Jun 15 1974 02:02:08 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ece2a576130a62bbbf",
                account_id = 2,
                amount = 6886.46,
                sender_name = "Zolar",
                sender_iban = "DE77575958259083706130486789",
                reference = "Id anim id et tempor. Do dolor duis mollit sunt occaecat.",
                date = "Wed Jun 18 1986 01:55:38 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec42026d7286c59b0f",
                account_id = 2,
                amount = 2672.0,
                sender_name = "Toyletry",
                sender_iban = "DE36119506593165542293756282",
                reference = "Quis ex dolor consequat ipsum exercitation non quis qui commodo.",
                date = "Mon Dec 31 2001 02:32:53 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec1985bc6bfab56c63",
                account_id = 2,
                amount = 4031.02,
                sender_name = "Sloganaut",
                sender_iban = "DE60089447791483184842290028",
                reference = "Amet nostrud officia aute laboris sunt officia tempor.",
                date = "Sat Nov 19 1977 16:52:00 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec67fc6f48a94ea542",
                account_id = 2,
                amount = 2612.11,
                sender_name = "Opticom",
                sender_iban = "DE23283837065671657097294892",
                reference = "Enim elit ullamco enim culpa tempor culpa excepteur anim aliqua ad commodo qui. Irure non id officia pariatur duis quis non in velit consequat mollit adipisicing dolor.",
                date = "Fri Jun 01 1990 17:53:08 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec7778bf1c3db63627",
                account_id = 2,
                amount = 4771.76,
                sender_name = "Singavera",
                sender_iban = "DE74615352043195634060113810",
                reference = "Magna sunt proident in labore duis eiusmod magna occaecat eiusmod eiusmod dolor sunt.",
                date = "Mon Sep 07 2015 10:47:49 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec09b0dc45b4c71dd2",
                account_id = 2,
                amount = 6857.8,
                sender_name = "Geologix",
                sender_iban = "DE17333532963884035239122759",
                reference = "Fugiat voluptate occaecat veniam voluptate incididunt aliquip et aute.",
                date = "Thu Jun 02 1994 05:41:28 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ece565b1e215b4e1ca",
                account_id = 2,
                amount = 7502.15,
                sender_name = "Elpro",
                sender_iban = "DE76623744987284550369494551",
                reference = "Consectetur consequat qui consequat elit. Tempor mollit qui minim voluptate esse nisi. Aute dolor elit deserunt labore irure dolore et tempor qui. Eu laborum laborum consequat labore magna ea reprehenderit.",
                date = "Fri Nov 15 2019 20:03:53 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec6630308beb4ed088",
                account_id = 2,
                amount = 9212.31,
                sender_name = "Orbin",
                sender_iban = "DE54948810595348840174865833",
                reference = "Ut incididunt ea ad ut laborum ea id eu.",
                date = "Sun Nov 06 1994 19:06:46 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec1c978bbdfd595cfd",
                account_id = 2,
                amount = 6115.13,
                sender_name = "Entroflex",
                sender_iban = "DE56666338558196988038814349",
                reference = "Ea est dolor ullamco eiusmod cillum consequat Lorem velit culpa. Sint amet eiusmod excepteur pariatur est. Voluptate consectetur cillum anim mollit qui ullamco minim elit do quis veniam nisi.",
                date = "Tue Jun 05 1984 03:25:48 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec7f5bff108d99b17b",
                account_id = 2,
                amount = 6862.68,
                sender_name = "Savvy",
                sender_iban = "DE70239862652861327246540999",
                reference = "Incididunt eiusmod reprehenderit veniam exercitation veniam commodo veniam sint culpa amet. Magna quis do reprehenderit et sint mollit commodo exercitation in incididunt proident.",
                date = "Thu Feb 19 2009 19:10:40 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec7e6377d754afab29",
                account_id = 2,
                amount = 4930.96,
                sender_name = "Rugstars",
                sender_iban = "DE94154048498564132663012087",
                reference = "Esse excepteur cillum amet amet ad fugiat consequat ea velit.",
                date = "Sun Jul 14 2013 15:56:31 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec411cc6ff914160f0",
                account_id = 2,
                amount = 4641.55,
                sender_name = "Ontality",
                sender_iban = "DE14622840409538696220417149",
                reference = "Id consequat occaecat duis sit id cillum officia. Aliquip anim est tempor labore minim commodo ullamco dolor sint incididunt ad ex nostrud cillum. Sunt do veniam aliqua laboris occaecat cillum minim minim aute dolore officia. Sint amet ut reprehenderit aliquip.",
                date = "Tue Mar 16 1971 10:36:12 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ece6e94370f6c61243",
                account_id = 2,
                amount = 86.38,
                sender_name = "Qualitern",
                sender_iban = "DE10210846823583609475163552",
                reference = "Deserunt qui elit sint commodo sunt veniam fugiat laboris nostrud mollit exercitation et quis sit.",
                date = "Fri Jan 15 1971 17:30:28 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecd728ae898b7ee604",
                account_id = 2,
                amount = 3631.68,
                sender_name = "Rubadub",
                sender_iban = "DE22620412379291017816688094",
                reference = "Consectetur reprehenderit nulla elit sint enim. In elit elit velit quis pariatur deserunt nostrud in aute in.",
                date = "Tue Nov 04 2003 01:24:56 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec137b9271a16d36a9",
                account_id = 2,
                amount = 8304.53,
                sender_name = "Pasturia",
                sender_iban = "DE84136468702398366863106848",
                reference = "Sint adipisicing laboris et exercitation laborum pariatur. Voluptate officia ut labore cupidatat in non mollit cillum cupidatat consectetur. Exercitation minim Lorem quis exercitation minim laborum sunt elit non reprehenderit non. Lorem do consequat nostrud commodo velit cupidatat nisi fugiat ut. Irure eu commodo sunt commodo non labore ullamco voluptate consequat commodo consequat ea.",
                date = "Mon Dec 04 1989 19:16:23 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec467a2b4887e13194",
                account_id = 2,
                amount = 6961.69,
                sender_name = "Knowlysis",
                sender_iban = "DE22729190209592001208922736",
                reference = "Elit do irure veniam qui nostrud aute dolor adipisicing laboris nisi proident enim aliqua.",
                date = "Thu Jan 27 2011 18:09:12 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec8f2f854ebeb68fd7",
                account_id = 2,
                amount = 4821.27,
                sender_name = "Zillacon",
                sender_iban = "DE12187924459780285111279618",
                reference = "Magna magna nisi officia ad sunt voluptate ex et. Exercitation esse nulla et sit occaecat.",
                date = "Thu Jan 12 2023 07:56:26 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec4171193fabc772cf",
                account_id = 2,
                amount = 4460.21,
                sender_name = "Yogasm",
                sender_iban = "DE11835332619220904323293871",
                reference = "Lorem officia voluptate aute non consectetur quis sint amet elit.",
                date = "Tue Apr 06 2010 16:39:15 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec95dc74358d289c3e",
                account_id = 2,
                amount = 1175.49,
                sender_name = "Comtours",
                sender_iban = "DE70283743992467327575941613",
                reference = "Nisi veniam velit cupidatat duis. Sunt enim commodo culpa consequat ut et consectetur ullamco eu anim do. Qui excepteur proident nisi amet mollit. Nisi consectetur veniam commodo ipsum minim aliqua minim dolore irure laboris irure velit culpa.",
                date = "Tue Feb 28 1995 23:10:17 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec59d9d97c2d2bd755",
                account_id = 2,
                amount = 2565.68,
                sender_name = "Accusage",
                sender_iban = "DE18173528649548724061490245",
                reference = "Laborum pariatur exercitation enim dolore cillum aute velit aliqua irure excepteur.",
                date = "Thu Mar 06 1997 07:45:52 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389eca6be359b7da3815a",
                account_id = 2,
                amount = 2053.29,
                sender_name = "Centuria",
                sender_iban = "DE77553944830583686935435915",
                reference = "Culpa esse ex id nostrud commodo mollit nisi cillum quis adipisicing commodo. Aliqua consequat culpa dolor commodo. Dolore sit non ea eu quis sunt irure. Laboris do proident adipisicing aliquip eu. Commodo anim sunt id velit Lorem reprehenderit cillum do magna mollit labore.",
                date = "Thu Mar 29 2018 04:22:51 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec2015cc865f059304",
                account_id = 2,
                amount = 7340.45,
                sender_name = "Centice",
                sender_iban = "DE83026126591037185882574182",
                reference = "Mollit sit voluptate duis deserunt esse mollit. Labore dolore fugiat irure aute eu. Sit tempor aliquip minim irure fugiat sit sint.",
                date = "Mon Dec 20 2010 16:28:08 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec2885772246d086b2",
                account_id = 2,
                amount = 1894.43,
                sender_name = "Comtest",
                sender_iban = "DE42277759544513303595674549",
                reference = "Id laboris occaecat Lorem cillum ullamco nulla cupidatat est eu irure ullamco consequat minim.",
                date = "Sat Jun 17 1978 04:50:44 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecadd487cd9b47799c",
                account_id = 2,
                amount = 8517.63,
                sender_name = "Remold",
                sender_iban = "DE94180128204468951358751442",
                reference = "Ipsum ipsum minim ea Lorem. In non ad enim do ad officia duis duis sunt qui. Aliquip commodo deserunt nulla amet anim eiusmod commodo cupidatat labore veniam cillum officia qui. Non nostrud elit consequat elit eu enim reprehenderit duis ea amet aute labore.",
                date = "Sun Nov 01 1981 19:22:09 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec97ba719c200764d9",
                account_id = 2,
                amount = 8029.88,
                sender_name = "Centregy",
                sender_iban = "DE41033141668536366103360357",
                reference = "Occaecat non elit incididunt commodo ullamco dolor anim ullamco ullamco Lorem proident mollit. Eiusmod velit amet nostrud ex.",
                date = "Tue Nov 26 2019 00:35:27 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec323a663cd681e457",
                account_id = 2,
                amount = 5595.4,
                sender_name = "Cytrak",
                sender_iban = "DE56742016108715748220196832",
                reference = "Aliquip deserunt consequat consequat dolore ex. Exercitation elit commodo ullamco deserunt fugiat nulla consequat aute excepteur quis. Eiusmod in aliquip enim laboris incididunt dolore. Pariatur cupidatat velit sit aliqua aliqua id cupidatat exercitation ut tempor sint incididunt aliquip.",
                date = "Wed Jan 22 1997 17:20:23 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec926588adf3f9c316",
                account_id = 2,
                amount = 6515.08,
                sender_name = "Vertide",
                sender_iban = "DE77586509906534703252131885",
                reference = "Fugiat eiusmod ullamco in culpa aliquip. Laboris proident nulla fugiat consequat irure Lorem enim dolore irure. Aute minim est ad ex laborum.",
                date = "Mon May 15 2006 18:51:08 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec925e65b3d4857409",
                account_id = 2,
                amount = 9958.1,
                sender_name = "Portalis",
                sender_iban = "DE79960981588064537641886748",
                reference = "Elit esse exercitation cupidatat ea tempor excepteur adipisicing sint. Quis non ipsum amet minim ipsum ut deserunt commodo elit esse nulla velit voluptate.",
                date = "Sun Nov 19 2017 05:05:33 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389eca630ad6675b13531",
                account_id = 2,
                amount = 1722.06,
                sender_name = "Mazuda",
                sender_iban = "DE34018101660254495264305691",
                reference = "Non aliquip anim ipsum do laboris exercitation. Qui excepteur laborum ex aliquip.",
                date = "Thu Jul 13 1972 19:08:04 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecc793b4eb30d78978",
                account_id = 2,
                amount = 4079.07,
                sender_name = "Melbacor",
                sender_iban = "DE94451050147575308224009096",
                reference = "Dolore excepteur anim ad cupidatat ea. Id minim in velit non nisi consectetur Lorem ullamco laboris ex quis. Eu enim magna veniam do aliquip excepteur quis elit veniam proident veniam. Culpa tempor magna et esse Lorem ipsum.",
                date = "Thu May 13 2004 11:30:30 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec6530ac7b07504633",
                account_id = 2,
                amount = 8900.87,
                sender_name = "Xinware",
                sender_iban = "DE99514527384042252434312293",
                reference = "Aliqua sit in laborum occaecat voluptate Lorem elit. Quis magna labore occaecat consectetur ipsum cupidatat consectetur veniam duis minim. Velit nostrud dolor adipisicing enim eu ullamco tempor ipsum occaecat id minim aute in nisi. Elit elit officia eiusmod aliquip sit aliqua fugiat irure eiusmod occaecat nostrud ad. Nulla sint elit fugiat proident mollit mollit sit.",
                date = "Fri Sep 29 1989 01:11:27 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecb067b3d4e81f3397",
                account_id = 2,
                amount = 1744.38,
                sender_name = "Pyramax",
                sender_iban = "DE70012011715482110483105486",
                reference = "Sit ex id cillum aute labore nisi nulla. Irure adipisicing nisi esse reprehenderit. Lorem voluptate cillum sunt incididunt exercitation. Labore laborum cillum voluptate est mollit sunt mollit dolor nostrud velit qui eu. Ullamco nulla reprehenderit proident sit fugiat sit aute sit.",
                date = "Fri Dec 24 2021 16:42:17 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec17f59380b1edffe2",
                account_id = 2,
                amount = 4614.3,
                sender_name = "Permadyne",
                sender_iban = "DE35980499519745337358344012",
                reference = "Et proident eu enim nostrud ipsum ut consectetur labore velit ut ipsum do.",
                date = "Thu Nov 12 2009 08:40:36 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec1e32230681168510",
                account_id = 2,
                amount = 4371.9,
                sender_name = "Digifad",
                sender_iban = "DE34142390948325035117537485",
                reference = "Cillum in incididunt qui minim officia deserunt dolor pariatur ullamco excepteur duis do. Ea exercitation Lorem occaecat nulla occaecat sint velit in laboris sunt cillum aliquip incididunt.",
                date = "Tue Jul 11 2006 11:41:47 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec8f5ec508446916ac",
                account_id = 2,
                amount = 2512.67,
                sender_name = "Earthmark",
                sender_iban = "DE51389831903555849785382019",
                reference = "Labore nulla deserunt culpa qui anim incididunt fugiat eiusmod fugiat consectetur in nostrud. Deserunt est proident Lorem incididunt proident ut occaecat officia mollit minim exercitation aliqua cillum nulla.",
                date = "Wed Mar 09 2022 01:28:03 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecd48fda17f135ceed",
                account_id = 2,
                amount = 4619.42,
                sender_name = "Temorak",
                sender_iban = "DE37123945306619242326647588",
                reference = "Aliquip magna consequat tempor excepteur dolore est eiusmod cillum. Nulla aliquip Lorem ullamco nostrud laborum. Nostrud eiusmod id laboris sint ex aliquip aliqua ex sit labore quis quis incididunt consectetur. Aliqua nostrud aliqua elit eu dolor aliqua ex aliquip non aliquip magna eu. Eu culpa excepteur id cillum minim amet ex incididunt fugiat.",
                date = "Tue Mar 06 2018 09:42:02 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec9c0052b9824b079a",
                account_id = 2,
                amount = 7942.24,
                sender_name = "Deepends",
                sender_iban = "DE79619018197064489973845957",
                reference = "Cillum duis cillum mollit ut. Consectetur esse laboris nulla culpa excepteur proident deserunt. Dolor quis aliquip sunt ex consectetur eu.",
                date = "Tue Sep 03 2002 14:08:34 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec180d728cdf37492c",
                account_id = 2,
                amount = 5890.35,
                sender_name = "Megall",
                sender_iban = "DE25326167853691758209104319",
                reference = "Aliquip laboris fugiat qui culpa officia magna.",
                date = "Thu Jul 18 1985 04:22:35 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec9ef241a2ac5ef628",
                account_id = 2,
                amount = 8688.46,
                sender_name = "Scentric",
                sender_iban = "DE99776365575914094372968682",
                reference = "Eu esse sint amet laborum in elit do ullamco excepteur consectetur. Nulla elit esse excepteur nostrud pariatur nisi proident anim cupidatat quis. Aliqua sunt excepteur do sit cillum nostrud.",
                date = "Mon Nov 25 1974 20:27:09 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec4e356c9d0c8db955",
                account_id = 2,
                amount = 511.65,
                sender_name = "Zilch",
                sender_iban = "DE78532725136871011268559161",
                reference = "Qui ad excepteur fugiat Lorem esse tempor culpa. Culpa aliqua officia et excepteur quis anim minim nulla mollit deserunt.",
                date = "Thu May 18 2017 13:01:08 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec37fc73bfe25e1caf",
                account_id = 2,
                amount = 3672.43,
                sender_name = "Daycore",
                sender_iban = "DE57831006095975045362672137",
                reference = "In et irure est nulla sit nisi quis voluptate consectetur pariatur pariatur et aute. Officia incididunt ut cupidatat consectetur anim minim. Aute elit ipsum veniam cillum anim reprehenderit irure voluptate amet adipisicing magna commodo ex. Ex officia incididunt aliqua adipisicing magna laboris labore deserunt nulla ex officia. Anim mollit ad excepteur incididunt.",
                date = "Mon Sep 26 1994 18:06:20 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecf4b340a6ebb4a754",
                account_id = 2,
                amount = 1485.06,
                sender_name = "Eargo",
                sender_iban = "DE41553015789259439176286087",
                reference = "Aute nulla ex amet voluptate. Ullamco elit amet aliquip consectetur amet enim proident nostrud deserunt aliquip aliqua. Quis minim minim ut adipisicing voluptate. Eiusmod est commodo veniam incididunt consectetur in pariatur excepteur irure.",
                date = "Wed Aug 30 1995 17:38:40 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec72520cc8c44f4faa",
                account_id = 2,
                amount = 1288.88,
                sender_name = "Elentrix",
                sender_iban = "DE91728141527449663198495965",
                reference = "Anim occaecat adipisicing adipisicing Lorem adipisicing.",
                date = "Mon Aug 10 2015 02:34:10 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec20978280cc4881c7",
                account_id = 2,
                amount = 3109.23,
                sender_name = "Naxdis",
                sender_iban = "DE62414662996958012476202322",
                reference = "Adipisicing minim enim cillum deserunt non laboris ut veniam irure.",
                date = "Wed Feb 21 2001 00:01:00 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ece43408baaec13663",
                account_id = 2,
                amount = 5000.58,
                sender_name = "Nebulean",
                sender_iban = "DE62210186299984240087049339",
                reference = "Esse commodo fugiat ad exercitation incididunt id voluptate laborum sint in cupidatat.",
                date = "Tue Aug 17 2010 02:12:45 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec7b08511bcd97ceee",
                account_id = 2,
                amount = 3999.45,
                sender_name = "Zoid",
                sender_iban = "DE37350471989999501166917694",
                reference = "Minim tempor tempor exercitation voluptate magna anim ut ipsum veniam incididunt veniam aute anim enim. Dolor excepteur non sint sunt est quis elit. Exercitation mollit dolore Lorem consectetur ipsum fugiat ullamco eu consequat ex et Lorem enim.",
                date = "Wed Dec 13 2006 07:21:42 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec79ed8ccf81cdcefa",
                account_id = 2,
                amount = 6333.5,
                sender_name = "Geekko",
                sender_iban = "DE52378926331865558785147448",
                reference = "Est officia laborum nisi tempor sint nostrud ad. Sint duis cillum esse ut sunt nulla. Consectetur do proident tempor Lorem eiusmod aliqua commodo laboris. Esse consectetur proident et officia nulla tempor ea sit pariatur sint commodo ut aliquip veniam.",
                date = "Thu Aug 09 2018 04:54:09 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389eca621108b8fd65940",
                account_id = 2,
                amount = 7110.8,
                sender_name = "Geostele",
                sender_iban = "DE66105527020054104684523673",
                reference = "Cupidatat ullamco irure adipisicing aute veniam sint cillum occaecat duis commodo aliqua. Irure laborum proident amet cupidatat quis esse laborum excepteur ad. In incididunt laboris veniam id nostrud tempor exercitation sunt. Proident aute ut sint proident eu ut elit minim et.",
                date = "Mon Oct 29 1979 19:12:13 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecf5975047ebca817c",
                account_id = 2,
                amount = 4543.16,
                sender_name = "Digigene",
                sender_iban = "DE32956782629891308827557476",
                reference = "Amet do nostrud et duis enim dolor duis reprehenderit do incididunt est cillum. Lorem occaecat anim ipsum pariatur id nostrud ex in aliquip aliquip. Nostrud et cupidatat id ex irure et occaecat nulla ex nostrud irure anim cillum Lorem. Dolor officia in et ut fugiat laborum esse. Esse elit laborum dolor occaecat ipsum laborum nulla ex reprehenderit laborum nisi cillum laborum adipisicing.",
                date = "Sat Sep 25 1976 06:20:16 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec889b82a783e725c7",
                account_id = 2,
                amount = 5164.26,
                sender_name = "Insectus",
                sender_iban = "DE81795779482623359932552433",
                reference = "Nisi qui officia esse ex.",
                date = "Mon May 03 1999 21:51:57 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec45609b33866fffa5",
                account_id = 2,
                amount = 5485.94,
                sender_name = "Anivet",
                sender_iban = "DE60129683350279989724038664",
                reference = "Exercitation cillum nostrud minim sunt cillum anim elit elit quis id. Non sit Lorem magna aliqua adipisicing sunt nostrud ex tempor id. Aliquip consequat laboris excepteur quis velit velit elit pariatur qui. Minim anim fugiat consectetur tempor nulla deserunt ullamco duis sit esse est culpa magna. Eu sunt enim consequat incididunt in officia amet.",
                date = "Thu Jul 08 1999 04:21:12 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecc0ffd18d94329dbd",
                account_id = 2,
                amount = 6014.39,
                sender_name = "Geofarm",
                sender_iban = "DE82199862561526045118058538",
                reference = "Nisi ad reprehenderit ut voluptate duis qui consectetur ex enim ut sit. Duis esse fugiat mollit cupidatat. Cupidatat ex amet veniam cillum consequat aliqua eiusmod ullamco amet exercitation tempor et elit aliqua.",
                date = "Thu Jan 03 2019 15:29:11 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec22d33c8f996d0b28",
                account_id = 2,
                amount = 8169.48,
                sender_name = "Rodeomad",
                sender_iban = "DE89994252096077880359109125",
                reference = "Voluptate qui aliquip aliquip velit excepteur pariatur. Adipisicing laboris quis culpa ipsum sit officia dolore dolor. Sit et nisi officia eiusmod exercitation dolor sint ea nostrud Lorem.",
                date = "Wed Aug 17 1988 09:12:52 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecd304c254be99c2c6",
                account_id = 2,
                amount = 7676.72,
                sender_name = "Snorus",
                sender_iban = "DE18140269498786170410843786",
                reference = "Officia ad veniam non ipsum velit aute occaecat aute nisi duis. Proident eu sunt anim ullamco duis cillum laborum mollit. Amet ullamco qui sit nostrud eiusmod tempor irure proident esse ipsum amet ea duis deserunt. Laboris commodo officia quis consectetur eu occaecat. Fugiat quis sit magna aute minim adipisicing consectetur.",
                date = "Mon Dec 28 2009 17:00:35 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecc7ba9da27fe7b554",
                account_id = 2,
                amount = 7744.19,
                sender_name = "Zinca",
                sender_iban = "DE36675374131921672441380455",
                reference = "Adipisicing laboris pariatur aliquip ut velit labore labore officia excepteur. Amet labore dolor anim Lorem ea minim dolor est officia laborum nisi. Exercitation sit anim tempor exercitation in eiusmod dolore mollit mollit dolore Lorem nisi deserunt. Quis enim eu ad laborum Lorem irure nulla velit irure fugiat dolor nostrud. Consectetur nulla consectetur laboris mollit culpa incididunt sint exercitation in eu exercitation adipisicing.",
                date = "Sun Apr 05 1981 10:44:09 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec280bf025e4c9c5bc",
                account_id = 2,
                amount = 9116.76,
                sender_name = "Reversus",
                sender_iban = "DE81109031998999443248951911",
                reference = "Amet ullamco ut proident enim quis qui officia veniam nisi. Laboris esse laborum non non nisi deserunt cillum nisi aliquip culpa. Sit officia nulla anim voluptate et dolor veniam ut ullamco fugiat mollit. Sint et cillum ipsum dolore sunt. Tempor sit nisi anim exercitation est sit amet.",
                date = "Sun Mar 14 1999 13:19:32 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec873afedbf066379f",
                account_id = 2,
                amount = 8741.75,
                sender_name = "Exiand",
                sender_iban = "DE18328866556240888908974043",
                reference = "Nisi commodo do aliquip nisi fugiat.",
                date = "Thu Feb 19 2004 20:29:14 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec59c4d674ea27acaa",
                account_id = 2,
                amount = 4527.67,
                sender_name = "Kidstock",
                sender_iban = "DE42365754791568328875140237",
                reference = "Consequat sint laboris consequat mollit aliqua officia occaecat id. Qui mollit ut cupidatat consequat cupidatat et commodo. Anim qui exercitation tempor pariatur. Ut consectetur adipisicing proident mollit do Lorem dolor consectetur nisi dolore. Sunt duis sunt nulla qui laborum quis velit amet aliquip enim reprehenderit velit dolor.",
                date = "Sat May 13 2023 05:38:45 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecbc9f2aebf006bec0",
                account_id = 2,
                amount = 6367.21,
                sender_name = "Uni",
                sender_iban = "DE82129988375564188448660576",
                reference = "Fugiat ipsum laboris dolore quis ea. Sunt veniam dolore dolore incididunt. Elit velit ex incididunt adipisicing sint. Minim deserunt tempor consequat dolor quis aliquip et laborum labore nisi laboris enim qui labore.",
                date = "Fri Dec 31 1976 03:40:30 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec08477a8905b16307",
                account_id = 2,
                amount = 9079.24,
                sender_name = "Digitalus",
                sender_iban = "DE99369825767212300941951357",
                reference = "Elit pariatur tempor qui cupidatat reprehenderit deserunt voluptate incididunt sint.",
                date = "Sat Jun 23 1973 09:09:54 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec7637d4262d7a6c9e",
                account_id = 2,
                amount = 8639.72,
                sender_name = "Ludak",
                sender_iban = "DE42896840596493405308817180",
                reference = "Adipisicing consequat exercitation proident do do velit irure proident. Do eiusmod aliqua exercitation cillum. Minim cillum velit pariatur amet voluptate magna minim amet non et.",
                date = "Fri May 04 1984 14:40:27 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ece8c04ed80cb1e02a",
                account_id = 2,
                amount = 4795.18,
                sender_name = "Konnect",
                sender_iban = "DE90522401742036382838392729",
                reference = "Occaecat labore enim occaecat sunt occaecat ex. Nulla labore elit labore adipisicing consectetur esse id. Incididunt qui officia excepteur quis. Incididunt anim eiusmod elit labore commodo eu.",
                date = "Mon Apr 15 2013 06:25:02 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec700407777c67b36a",
                account_id = 2,
                amount = 3745.41,
                sender_name = "Progenex",
                sender_iban = "DE81173077057815325150394071",
                reference = "Enim laboris fugiat nulla id ut qui fugiat id elit veniam dolor. Aliqua consectetur officia cillum adipisicing velit cillum. Ipsum minim magna ut ea. Cillum sunt excepteur nostrud nostrud do quis esse magna deserunt et eu ea.",
                date = "Mon Jan 17 2005 11:15:54 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec3eac0d738530ae8a",
                account_id = 2,
                amount = 1362.12,
                sender_name = "Accidency",
                sender_iban = "DE21653606486144823765936722",
                reference = "Consectetur nulla ad culpa laboris sunt ut elit enim quis.",
                date = "Sat Dec 15 1990 12:51:45 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec72e393f2a131ff5c",
                account_id = 2,
                amount = 6909.29,
                sender_name = "Terrasys",
                sender_iban = "DE60540900893644253375530325",
                reference = "In id in occaecat magna eiusmod commodo officia ullamco esse laborum occaecat. In cupidatat ad excepteur officia commodo dolor amet proident duis excepteur adipisicing eu. Quis exercitation quis qui dolor culpa ea excepteur aute deserunt ex mollit nostrud veniam. Enim est dolore ullamco voluptate.",
                date = "Fri Aug 29 2014 21:52:42 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecb84fbb7bb21ffd64",
                account_id = 2,
                amount = 8907.53,
                sender_name = "Translink",
                sender_iban = "DE46731985837193220056143236",
                reference = "Tempor minim excepteur enim eiusmod nisi ullamco Lorem in eiusmod. Est cupidatat nulla est ea tempor voluptate. Veniam aute exercitation incididunt incididunt elit. Magna do sint dolore mollit sunt labore fugiat. Magna ea irure magna proident ut labore ea Lorem ullamco.",
                date = "Tue Nov 27 1984 09:05:40 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec5a3a054991f1e4b2",
                account_id = 2,
                amount = 1345.75,
                sender_name = "Exozent",
                sender_iban = "DE10178061379518671193865265",
                reference = "Proident fugiat do ad ipsum aute commodo exercitation veniam officia. Consequat anim pariatur irure tempor aute aliquip ut. Labore amet nulla ex fugiat occaecat esse aute aute officia aute veniam labore ullamco.",
                date = "Thu Dec 25 1980 01:19:12 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec108dc4409033208e",
                account_id = 2,
                amount = 1514.18,
                sender_name = "Syntac",
                sender_iban = "DE54170255670828694131815648",
                reference = "Nostrud dolore nulla et nostrud deserunt consequat id in officia. Duis ipsum cillum exercitation cupidatat duis aute exercitation culpa sint Lorem aute non labore nulla. Nostrud labore minim aliquip mollit in cupidatat aliquip ad ex deserunt mollit aliquip.",
                date = "Thu May 05 1977 21:10:58 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecbc316fe96da1ed32",
                account_id = 2,
                amount = 1383.15,
                sender_name = "Asimiline",
                sender_iban = "DE54485453548669874416368418",
                reference = "Ullamco duis anim eu minim pariatur minim consequat exercitation nostrud excepteur Lorem. Ea ad tempor fugiat ipsum cupidatat elit ullamco consectetur excepteur Lorem dolor pariatur sunt mollit.",
                date = "Thu Jun 24 1993 04:40:26 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec3ef7914af6721abb",
                account_id = 2,
                amount = 6756.11,
                sender_name = "Zentix",
                sender_iban = "DE31760386359624874918033152",
                reference = "Cupidatat deserunt cupidatat officia officia commodo elit officia labore exercitation reprehenderit anim duis id incididunt. Consequat minim anim quis mollit enim occaecat adipisicing veniam aute consequat officia consectetur. Aliquip ullamco proident labore commodo voluptate ea aliqua ex aliquip anim exercitation adipisicing aute aliqua.",
                date = "Wed May 05 2021 20:54:10 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec7363cfb6ce6a79c2",
                account_id = 2,
                amount = 1732.68,
                sender_name = "Xumonk",
                sender_iban = "DE58124126700163074270343735",
                reference = "Eu Lorem amet qui sint. Commodo esse id labore ut labore tempor cillum fugiat eu exercitation ad magna.",
                date = "Mon Jun 29 1981 07:11:56 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec0ca49b6de8af89b6",
                account_id = 2,
                amount = 7618.73,
                sender_name = "Gluid",
                sender_iban = "DE15574666794655318740961384",
                reference = "Cillum ullamco pariatur id et veniam nisi nisi non. Nisi cillum fugiat aute eu.",
                date = "Wed Sep 30 1987 13:49:38 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389eca401fbbea25ca857",
                account_id = 2,
                amount = 1411.49,
                sender_name = "Pivitol",
                sender_iban = "DE86037177735425492586938051",
                reference = "Nostrud magna eiusmod in veniam aliqua eu deserunt ad eu irure. Enim ipsum nostrud officia enim. Eiusmod magna magna exercitation amet aliquip dolore enim qui tempor consectetur amet esse.",
                date = "Mon Jun 18 1979 17:22:15 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecadaa79e9ef317a75",
                account_id = 2,
                amount = 7986.68,
                sender_name = "Volax",
                sender_iban = "DE63379603169670163484669895",
                reference = "Et reprehenderit amet est excepteur anim. Minim commodo do in magna consequat sint eu consectetur sunt. Labore pariatur sint nisi cillum tempor excepteur dolor ea consequat Lorem mollit in dolore. Incididunt non aute sunt aliqua ut. Elit est est consectetur mollit in mollit minim et pariatur irure irure incididunt sit.",
                date = "Fri Mar 05 1982 04:29:39 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecdd72edcf1a321766",
                account_id = 2,
                amount = 1969.78,
                sender_name = "Enthaze",
                sender_iban = "DE70073254677312005091642132",
                reference = "Velit ipsum do non deserunt elit pariatur pariatur mollit deserunt Lorem minim. Esse ex cupidatat sit incididunt eu voluptate sint laborum laborum. Sint irure dolor cillum cillum deserunt eu. Cillum consectetur eiusmod duis nulla.",
                date = "Fri May 08 2020 12:26:21 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec6766ce32cf948bbb",
                account_id = 2,
                amount = 9453.87,
                sender_name = "Aeora",
                sender_iban = "DE42108111423119383813842418",
                reference = "Qui exercitation laborum id fugiat commodo culpa tempor et aliqua nostrud duis. Aute reprehenderit amet ipsum et officia.",
                date = "Mon May 28 2012 21:46:31 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec6e840dfb2f44ff54",
                account_id = 2,
                amount = 218.99,
                sender_name = "Xurban",
                sender_iban = "DE54096561646052718750460358",
                reference = "Labore amet elit laboris officia et tempor. Eiusmod mollit sint est dolor culpa officia pariatur enim laboris. Reprehenderit aliquip aliquip eiusmod proident nisi eu consectetur. Esse cillum nostrud cillum dolore cupidatat nisi pariatur ea exercitation velit aliqua anim nisi.",
                date = "Mon Mar 19 1990 22:22:14 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec5b2b02fb1ec8e05c",
                account_id = 2,
                amount = 6416.34,
                sender_name = "Fossiel",
                sender_iban = "DE98046861733372326068961179",
                reference = "Duis id minim ex dolore qui commodo. Labore non consequat aliquip aute ullamco. Quis ea esse laboris culpa. Velit laborum ea excepteur ex anim id reprehenderit amet voluptate nostrud.",
                date = "Wed Mar 04 1981 23:59:28 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecf6cb7cb4efdc79ef",
                account_id = 2,
                amount = 3315.89,
                sender_name = "Exoteric",
                sender_iban = "DE74024754646126538817886884",
                reference = "Exercitation fugiat non voluptate sint eu cupidatat quis.",
                date = "Sat Jul 28 1984 03:32:32 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecac967d1e8ed2fc66",
                account_id = 2,
                amount = 8036.43,
                sender_name = "Gynk",
                sender_iban = "DE99879451599973336970557323",
                reference = "Magna amet consequat ipsum commodo. Excepteur eiusmod esse ullamco ad non occaecat. Fugiat labore et mollit laboris magna mollit et in aute est id aliquip ex.",
                date = "Fri Jul 15 1977 10:54:40 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec6ee4302586e9dca3",
                account_id = 2,
                amount = 2016.13,
                sender_name = "Ovium",
                sender_iban = "DE12685096678874175561305466",
                reference = "Id ipsum ex sit incididunt elit qui esse. Id ipsum id exercitation irure consectetur occaecat incididunt. Pariatur reprehenderit et incididunt aute. Sit nulla proident occaecat sunt nostrud dolor enim ullamco ad sit do exercitation voluptate ea. Consequat Lorem eu eiusmod id et velit voluptate duis aliqua velit.",
                date = "Tue Mar 18 1997 07:17:52 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec68b5f27ba769290f",
                account_id = 2,
                amount = 3960.79,
                sender_name = "Earbang",
                sender_iban = "DE50945904370350426119008796",
                reference = "Anim aliquip ullamco culpa irure deserunt veniam sunt dolore officia non deserunt qui.",
                date = "Sun Nov 13 2005 18:57:00 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec6b2287855f4287a1",
                account_id = 2,
                amount = 6886.46,
                sender_name = "Digirang",
                sender_iban = "DE26157726350110944482948162",
                reference = "Ullamco exercitation fugiat nulla commodo cupidatat nisi tempor labore. Dolore eu culpa fugiat quis magna.",
                date = "Wed Nov 17 2021 01:25:07 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecdda5c279cbd4c9c6",
                account_id = 2,
                amount = 1059.63,
                sender_name = "Pulze",
                sender_iban = "DE67357160205160263873590498",
                reference = "Velit aute do eiusmod qui exercitation reprehenderit velit aliqua pariatur consequat deserunt. Est duis minim minim quis eiusmod. Nostrud aliquip nulla exercitation enim. Nostrud velit non nostrud mollit consectetur magna aliqua. Ut qui ut ea laborum eu veniam ad cupidatat culpa adipisicing laboris amet minim quis.",
                date = "Tue May 03 2011 15:52:50 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecdda505ede75a2d73",
                account_id = 2,
                amount = 2305.99,
                sender_name = "Steeltab",
                sender_iban = "DE15552780314925790925266355",
                reference = "In minim laboris occaecat laboris exercitation nulla do aliqua. Ullamco est consectetur elit elit exercitation ea est dolore laboris ipsum ad sunt ea. Excepteur nisi sit culpa culpa sit ex pariatur labore occaecat.",
                date = "Sun Sep 09 2012 13:07:51 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecdcc2640636ef2738",
                account_id = 2,
                amount = 1641.95,
                sender_name = "Tubesys",
                sender_iban = "DE68330829551193434355870890",
                reference = "Elit occaecat nisi officia deserunt velit eu. Laborum dolor elit eiusmod ullamco exercitation officia tempor velit in et elit aliqua. Ex ullamco labore adipisicing nisi.",
                date = "Fri Sep 30 2016 01:13:09 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec36c783c3bf582241",
                account_id = 2,
                amount = 2198.34,
                sender_name = "Telepark",
                sender_iban = "DE80639999172382070290361024",
                reference = "Non ut labore Lorem Lorem. Exercitation ipsum irure incididunt enim sit id est cupidatat aute consectetur nisi exercitation dolore.",
                date = "Thu Feb 19 2015 11:24:30 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec8ea0d154ee4f38fc",
                account_id = 2,
                amount = 4928.79,
                sender_name = "Comtrek",
                sender_iban = "DE50768530019320633283458811",
                reference = "Eiusmod id eiusmod do eu quis sit officia eu velit.",
                date = "Sun Aug 02 1992 00:41:50 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec5905321259179a03",
                account_id = 2,
                amount = 2665.58,
                sender_name = "Phormula",
                sender_iban = "DE38635386745474698682624491",
                reference = "Ipsum commodo eu magna reprehenderit ipsum sunt dolor amet mollit adipisicing dolor Lorem fugiat et. Cupidatat dolore deserunt proident irure do fugiat qui reprehenderit voluptate velit nisi duis aute. Duis quis nostrud duis dolore sit mollit in adipisicing occaecat laboris duis qui. Voluptate tempor irure in minim Lorem eu proident magna ad. Cillum aute consectetur ut cupidatat irure ex.",
                date = "Wed Sep 15 1971 09:55:54 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec2270934bea498c37",
                account_id = 2,
                amount = 2165.42,
                sender_name = "Oatfarm",
                sender_iban = "DE89987676717453314031998371",
                reference = "Amet fugiat anim nostrud ad reprehenderit est duis aliqua amet et ea et laborum irure. Aliquip minim elit in ex dolor. Velit sit et labore anim aliquip magna officia reprehenderit officia ad nisi ipsum eiusmod. Exercitation ut dolore adipisicing excepteur.",
                date = "Wed Jun 17 1970 22:18:29 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec19c6714f4c4ba942",
                account_id = 2,
                amount = 2638.94,
                sender_name = "Homelux",
                sender_iban = "DE43474479020874621295797527",
                reference = "Ex eiusmod id consectetur occaecat ut incididunt.",
                date = "Tue Oct 12 2004 13:35:59 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec703c08f1c5286a94",
                account_id = 2,
                amount = 6386.78,
                sender_name = "Retrack",
                sender_iban = "DE43465931015045313078154089",
                reference = "Reprehenderit et aliqua non pariatur nulla qui consectetur mollit ipsum exercitation occaecat irure. Mollit ut nostrud velit nulla tempor laboris do eiusmod reprehenderit nostrud. Consequat mollit dolor labore sunt mollit non eiusmod velit veniam aliqua deserunt magna laboris aliqua. Labore sint qui veniam deserunt esse enim aliqua labore eiusmod proident deserunt irure.",
                date = "Sat Feb 10 1996 15:42:49 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec5ac611e87f0674f1",
                account_id = 2,
                amount = 2617.27,
                sender_name = "Kidgrease",
                sender_iban = "DE38266755946540963480255052",
                reference = "Aute occaecat laboris magna elit excepteur sit. Elit dolor sunt fugiat nulla veniam. Mollit est laboris elit dolor cillum officia duis. Ea aliquip non enim est dolore cupidatat mollit Lorem esse fugiat.",
                date = "Thu Dec 04 2008 08:25:59 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec7dbb52c28ae94436",
                account_id = 2,
                amount = 4605.61,
                sender_name = "Dognost",
                sender_iban = "DE65644649536549924688546859",
                reference = "Voluptate mollit sint labore do eu voluptate do pariatur do officia reprehenderit. Adipisicing excepteur quis culpa minim esse minim commodo ipsum consectetur proident in. Laboris nisi reprehenderit adipisicing qui aliquip id duis ea officia eiusmod.",
                date = "Wed Sep 24 2008 15:06:35 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec6bb2542f3ccd78e2",
                account_id = 2,
                amount = 4236.35,
                sender_name = "Aquacine",
                sender_iban = "DE19292027816359155993254670",
                reference = "Aute nulla quis non ex adipisicing exercitation dolor dolor in esse irure. Qui excepteur esse sit consectetur amet consequat ipsum et cillum cupidatat voluptate est elit eiusmod. Ex nulla sit incididunt duis ad nisi Lorem ut incididunt velit minim. Eiusmod ut fugiat incididunt sit minim exercitation eiusmod dolor commodo ea velit.",
                date = "Tue Jun 04 1991 15:47:32 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecb5d5d307a8a7071d",
                account_id = 2,
                amount = 9042.13,
                sender_name = "Strezzo",
                sender_iban = "DE17745350845030856317253123",
                reference = "Lorem deserunt et magna ipsum ea magna non duis. Cillum proident tempor ad irure voluptate aliquip mollit occaecat qui consectetur occaecat pariatur ex.",
                date = "Tue Jul 01 2014 22:12:40 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec22dfe017b6cd9c64",
                account_id = 2,
                amount = 5282.23,
                sender_name = "Avit",
                sender_iban = "DE88523966822649982379605455",
                reference = "Nulla velit minim Lorem excepteur consectetur et ut do velit.",
                date = "Tue May 19 2015 18:02:04 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec192fb2dff5a298e8",
                account_id = 2,
                amount = 3598.93,
                sender_name = "Fitcore",
                sender_iban = "DE23369625640411676328950249",
                reference = "Sint reprehenderit tempor commodo commodo magna occaecat occaecat est sit. Sit id sunt adipisicing consequat officia laborum. Ex consequat dolor cupidatat in. Aute aliquip velit magna exercitation sint voluptate minim pariatur non officia.",
                date = "Thu Dec 02 1971 12:41:50 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec98ecfd9f17ece4b7",
                account_id = 2,
                amount = 1099.05,
                sender_name = "Plasmos",
                sender_iban = "DE33820346974095032468859495",
                reference = "Elit cupidatat eiusmod nostrud aliqua proident. Officia consequat Lorem eiusmod in voluptate eiusmod velit. Duis nostrud excepteur exercitation officia elit dolore ut nisi voluptate Lorem aute esse aute. Eu deserunt esse in qui aliqua non voluptate aute consectetur.",
                date = "Tue Feb 23 1982 19:28:01 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec0bcabd259fa9cde8",
                account_id = 2,
                amount = 3014.67,
                sender_name = "Zytrax",
                sender_iban = "DE34988070149685269875415699",
                reference = "Sit aute nulla irure laboris ea aliquip adipisicing consequat cupidatat tempor cillum. Pariatur adipisicing do do nisi ad aliquip incididunt ullamco magna aliqua velit.",
                date = "Mon Dec 13 2010 22:27:56 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec5ee2b68adff48f85",
                account_id = 2,
                amount = 1173.3,
                sender_name = "Comvey",
                sender_iban = "DE34238025859969280093843922",
                reference = "Tempor aliqua dolore officia ullamco duis aliquip dolore officia ex dolor ipsum do. Minim laboris nulla sunt nulla qui voluptate pariatur veniam adipisicing aliquip exercitation nostrud ex duis. Consequat commodo elit nulla duis laboris amet exercitation esse. Laborum voluptate tempor incididunt eiusmod pariatur ea dolor eu nulla cillum minim qui nostrud.",
                date = "Thu Apr 02 1992 02:55:07 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec5cfbc43e0ecc34f1",
                account_id = 2,
                amount = 7920.06,
                sender_name = "Krog",
                sender_iban = "DE19137511508037177259968190",
                reference = "Ex occaecat exercitation pariatur est laboris laborum nisi. Ad do pariatur aliquip ullamco ipsum sit velit pariatur ex tempor commodo ea eiusmod quis.",
                date = "Fri Apr 20 2012 16:58:40 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec3939b694c35d9cbd",
                account_id = 2,
                amount = 6288.4,
                sender_name = "Lingoage",
                sender_iban = "DE39744944978332206020013064",
                reference = "Deserunt id est esse nisi mollit elit amet quis veniam amet ipsum anim. Mollit id nostrud consectetur aliqua commodo cupidatat eu do ullamco.",
                date = "Thu Dec 31 1970 10:37:56 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec96a1e13cff89681d",
                account_id = 2,
                amount = 7562.99,
                sender_name = "Corporana",
                sender_iban = "DE63131746395364241176925574",
                reference = "Labore commodo eiusmod sit cupidatat enim sit ullamco cillum nostrud eu fugiat eu sint.",
                date = "Fri Feb 01 2019 17:45:32 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecf11228ff9ab1ff0b",
                account_id = 2,
                amount = 4061.57,
                sender_name = "Myopium",
                sender_iban = "DE30717423384790990694963983",
                reference = "Excepteur consectetur sint consequat consequat aute laboris incididunt et labore aliqua veniam labore laboris aliquip. Nulla adipisicing enim ea adipisicing labore consectetur occaecat mollit occaecat anim. Do nostrud ea aute eu Lorem laboris id nulla excepteur ut proident aliquip aliquip. Voluptate consequat nostrud Lorem dolore occaecat sunt sit proident irure exercitation cupidatat. Anim enim officia incididunt Lorem.",
                date = "Thu Jul 11 1996 18:24:49 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecbba5bd9631deaaa3",
                account_id = 2,
                amount = 7171.06,
                sender_name = "Darwinium",
                sender_iban = "DE97601775956222245028512485",
                reference = "Sit anim amet aliqua anim sint consectetur id enim.",
                date = "Wed Apr 07 2021 19:28:14 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecd5e8f2d5d30eeee0",
                account_id = 2,
                amount = 4693.21,
                sender_name = "Corecom",
                sender_iban = "DE65280260081611411378175062",
                reference = "Aliquip exercitation duis sunt consectetur nisi ex mollit. Amet dolor aute tempor nulla sint sit esse laboris elit qui sunt. Commodo est consectetur anim voluptate non voluptate non non amet in ullamco proident consequat.",
                date = "Tue Dec 14 2021 14:14:51 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecb4dacac71918de22",
                account_id = 2,
                amount = 6974.06,
                sender_name = "Sentia",
                sender_iban = "DE73693954714494137630052940",
                reference = "Minim in in est est aute. Aute ex magna sint excepteur deserunt. Eiusmod laboris velit ut fugiat et eu id eiusmod ipsum occaecat reprehenderit. Sit labore magna amet ut ut sint qui ea. Velit ad nulla ex esse velit tempor amet.",
                date = "Wed May 12 1999 21:11:57 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ece51ba2ac605fb34f",
                account_id = 2,
                amount = 6184.8,
                sender_name = "Nspire",
                sender_iban = "DE31510343040351396311197451",
                reference = "Pariatur aliqua nulla qui et in. Ad reprehenderit exercitation adipisicing exercitation pariatur ipsum elit ad veniam. Sit dolore quis laboris est eu voluptate amet non do Lorem eu duis. Fugiat laborum velit velit veniam sint cupidatat sint sit officia exercitation non cupidatat ut.",
                date = "Thu Apr 19 2001 03:46:02 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec788fb33f57c0263e",
                account_id = 2,
                amount = 7797.97,
                sender_name = "Geeky",
                sender_iban = "DE62246613865478532284420980",
                reference = "Enim irure adipisicing eu sunt.",
                date = "Sat May 28 1983 08:31:10 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec811dd98708b446c6",
                account_id = 2,
                amount = 4289.79,
                sender_name = "Jimbies",
                sender_iban = "DE85264230280979138487804470",
                reference = "Sunt eiusmod voluptate duis minim adipisicing laborum duis. Sunt pariatur id ea commodo.",
                date = "Fri Jan 30 2009 15:58:38 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecf07874ed07338406",
                account_id = 2,
                amount = 6879.66,
                sender_name = "Parleynet",
                sender_iban = "DE80877558978878347930987225",
                reference = "Veniam cupidatat pariatur nostrud est pariatur et.",
                date = "Wed Mar 01 2017 17:38:44 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec834fab1c1e741c94",
                account_id = 2,
                amount = 634.78,
                sender_name = "Isodrive",
                sender_iban = "DE56558755948556459415812242",
                reference = "Ut adipisicing quis veniam sint ipsum exercitation eu cupidatat ad consequat sint nisi non in. Eiusmod magna anim voluptate ex.",
                date = "Fri Nov 18 2005 10:17:05 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec63d8ec3cafd142ad",
                account_id = 2,
                amount = 3348.79,
                sender_name = "Acumentor",
                sender_iban = "DE38901154078377063767588820",
                reference = "Aliquip esse dolore anim ea eiusmod ut cupidatat id. Excepteur veniam eu sunt do occaecat in ipsum esse incididunt ullamco incididunt est mollit. Commodo quis cupidatat exercitation nulla labore dolor laboris minim irure incididunt cillum enim. Nostrud anim ipsum exercitation nisi proident culpa quis non dolore velit cupidatat minim aliquip commodo. Anim dolore exercitation exercitation tempor magna consectetur nisi in voluptate eiusmod laborum.",
                date = "Sun Aug 25 2019 05:15:13 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecaf4c63eeeb5b1105",
                account_id = 2,
                amount = 2125.09,
                sender_name = "Otherside",
                sender_iban = "DE71622355211545798917045968",
                reference = "Veniam anim ullamco velit cillum exercitation. Dolor ex cupidatat aute amet eu elit labore tempor.",
                date = "Tue Mar 09 1971 04:26:24 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec36a80d4eb0850deb",
                account_id = 2,
                amount = 7271.84,
                sender_name = "Idego",
                sender_iban = "DE81825657949629525362955226",
                reference = "Officia incididunt irure amet incididunt cupidatat irure. Pariatur tempor sunt enim cillum consequat ea. Dolore laboris laborum adipisicing aliqua anim commodo aliqua dolor amet. Laborum ex nisi ipsum elit sunt laborum consequat.",
                date = "Fri Jun 05 2009 17:39:18 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec8d6a1524740352e8",
                account_id = 2,
                amount = 8187.44,
                sender_name = "Farmage",
                sender_iban = "DE76675818311997886976432149",
                reference = "Adipisicing consectetur do aliquip consequat incididunt adipisicing aliquip. Ullamco est id consequat qui reprehenderit consequat voluptate nulla voluptate. Magna proident eu enim ut officia cupidatat in ex elit.",
                date = "Fri Aug 15 1986 01:34:35 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec954d699c33b0fbf4",
                account_id = 2,
                amount = 2596.15,
                sender_name = "Qiao",
                sender_iban = "DE60678343153656474628514410",
                reference = "Ut mollit veniam consectetur proident exercitation est est.",
                date = "Wed Feb 05 2003 10:41:48 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec0cab556ffad60c4e",
                account_id = 2,
                amount = 6126.05,
                sender_name = "Assitia",
                sender_iban = "DE76273803079071910870658324",
                reference = "Consectetur nostrud elit laboris qui pariatur. Labore Lorem consequat anim enim. Lorem do enim aliquip ex cupidatat occaecat laborum est non voluptate dolore dolore exercitation.",
                date = "Tue Sep 06 1994 03:01:11 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec017edfe0f0039857",
                account_id = 2,
                amount = 4348.6,
                sender_name = "Furnitech",
                sender_iban = "DE55520156016350176246830810",
                reference = "Exercitation sunt esse reprehenderit duis dolor incididunt velit labore qui occaecat magna aute. Occaecat commodo laborum nulla magna sint non minim Lorem consectetur elit cupidatat cupidatat incididunt. Dolor cupidatat et irure duis veniam ut cillum cupidatat veniam velit irure ipsum nulla. Aliquip sit nostrud eiusmod ut deserunt. Aliqua consectetur cillum adipisicing id reprehenderit tempor excepteur.",
                date = "Mon Jan 13 1975 17:36:39 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec1ad77dc6874ed91a",
                account_id = 2,
                amount = 8650.27,
                sender_name = "Boink",
                sender_iban = "DE89394063655124678500822913",
                reference = "Deserunt adipisicing veniam elit occaecat. Sit magna non elit eu anim consectetur duis tempor.",
                date = "Thu Dec 18 1980 23:26:33 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec1f770ec304cdedf0",
                account_id = 2,
                amount = 3729.8,
                sender_name = "Insurity",
                sender_iban = "DE54464107893478810761788955",
                reference = "Minim consequat nostrud irure enim tempor nisi eiusmod voluptate irure. Esse velit reprehenderit consectetur velit occaecat sint in nulla mollit. Nulla aliqua aute dolor mollit consequat aliquip non sunt. In Lorem excepteur pariatur aute nisi irure amet consectetur sit exercitation excepteur ipsum. Ullamco cupidatat velit pariatur ut ex sunt aute eu enim duis cillum aliquip.",
                date = "Sat Oct 16 1999 00:12:42 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec79d1e7b9411b7fe6",
                account_id = 2,
                amount = 1349.6,
                sender_name = "Zilladyne",
                sender_iban = "DE21228874442053984750131349",
                reference = "Officia exercitation aliquip minim laborum qui excepteur adipisicing aliqua sit incididunt veniam tempor. Laborum quis nulla et aliquip ullamco consectetur consequat nisi reprehenderit. Culpa quis amet dolor reprehenderit anim ut magna dolore eiusmod. Do ipsum ipsum fugiat exercitation cupidatat sit tempor in ipsum aute officia. In consectetur laboris ullamco nostrud cillum mollit irure duis duis ipsum nulla laborum.",
                date = "Sat Mar 25 1995 18:32:36 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec27d8e80f69b0ecc8",
                account_id = 2,
                amount = 3442.04,
                sender_name = "Accel",
                sender_iban = "DE68335995491686078785299039",
                reference = "In ut irure sint ex aliquip mollit dolor dolore sit aliqua esse ullamco amet. Sint aute pariatur deserunt cupidatat in duis sint dolore anim mollit.",
                date = "Sun Aug 27 1995 23:13:22 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec27176f0ae5dac8f1",
                account_id = 2,
                amount = 3611.17,
                sender_name = "Cubicide",
                sender_iban = "DE49927428261214362747785367",
                reference = "Et et labore aliquip amet excepteur veniam. Aute cupidatat nostrud incididunt et laborum occaecat ea quis esse occaecat commodo ipsum. Sit occaecat et aute labore excepteur duis culpa enim eu ea eiusmod minim magna ullamco. Incididunt adipisicing veniam anim amet deserunt fugiat reprehenderit exercitation minim deserunt. Velit occaecat commodo voluptate nisi in pariatur dolor nulla incididunt.",
                date = "Wed Jan 05 1983 10:49:41 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec3c18e88443731064",
                account_id = 2,
                amount = 8461.27,
                sender_name = "Lexicondo",
                sender_iban = "DE53760928422936475739229591",
                reference = "Magna magna sint labore est. Ullamco nisi esse ea duis ad consectetur reprehenderit nisi excepteur irure velit culpa. Incididunt excepteur officia dolor ex. Elit irure labore consectetur officia sunt proident occaecat ut magna do aliquip. Excepteur nisi aliqua et in sit duis.",
                date = "Fri Jan 31 2020 16:51:34 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecb1a07c0265e9d41e",
                account_id = 2,
                amount = 6558.68,
                sender_name = "Solgan",
                sender_iban = "DE91379133404119344566728724",
                reference = "Et cupidatat non ullamco enim fugiat non commodo incididunt cupidatat. Aute ex excepteur laboris pariatur ipsum mollit minim elit in nulla. Occaecat incididunt nulla commodo irure fugiat culpa eu irure incididunt cillum dolore. Sunt consectetur ad pariatur ullamco aute anim nostrud laborum qui. Occaecat excepteur dolore do Lorem voluptate consectetur Lorem aliquip eu aliqua aute.",
                date = "Thu Oct 16 2003 03:56:01 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecb22c443fe7b08c68",
                account_id = 2,
                amount = 4574.24,
                sender_name = "Qaboos",
                sender_iban = "DE51726293626867683720957343",
                reference = "Et nulla nulla tempor Lorem voluptate ad laboris reprehenderit ex amet non nulla. Consectetur irure ex culpa est ex qui esse occaecat. Consectetur in culpa ex fugiat excepteur minim amet nulla aliquip irure voluptate elit.",
                date = "Fri Aug 20 1976 23:41:38 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ece79dcf94f413ba2b",
                account_id = 2,
                amount = 4557.88,
                sender_name = "Gallaxia",
                sender_iban = "DE13226364654688156657357186",
                reference = "Veniam nulla pariatur et voluptate amet ea amet proident aliquip labore laboris occaecat minim. Deserunt anim ipsum laborum reprehenderit fugiat consectetur ad ea nulla elit elit.",
                date = "Fri Mar 20 1981 01:37:12 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ec577087062ba55bb0",
                account_id = 2,
                amount = 6108.6,
                sender_name = "Chorizon",
                sender_iban = "DE84775871883896314426570158",
                reference = "Laborum non labore tempor in et exercitation cupidatat velit consequat est. Dolor cupidatat voluptate dolore commodo incididunt cillum. Esse duis ut ullamco veniam anim ex incididunt incididunt velit pariatur ipsum deserunt minim esse. Est quis non quis dolore ex laboris nisi. Reprehenderit amet in nisi velit quis sit occaecat.",
                date = "Tue Jun 16 1970 10:24:25 GMT+0100 (Mitteleuropäische Normalzeit)"
            ),
            TurnoverAcc(
                id = "64c389ecee516eafb32817c0",
                account_id = 2,
                amount = 8652.3,
                sender_name = "Entality",
                sender_iban = "DE10060536510352854469683688",
                reference = "Ad incididunt duis excepteur excepteur aute laboris.",
                date = "Mon Apr 25 2011 15:48:31 GMT+0200 (Mitteleuropäische Sommerzeit)"
            ),
        )

        assertEquals(getTurnovers("1"),turnoverAccounts1)
    }

}
