package ua.itaysonlab.catogram.preferences

import org.telegram.messenger.LocaleController
import org.telegram.messenger.R
import org.telegram.ui.ActionBar.BaseFragment
import org.telegram.ui.LaunchActivity
import org.telegram.messenger.AndroidUtilities
import ua.itaysonlab.catogram.preferences.ktx.category
import ua.itaysonlab.catogram.preferences.ktx.textDetail
import ua.itaysonlab.catogram.preferences.ktx.textIcon
import ua.itaysonlab.catogram.preferences.ktx.tgKitScreen
import ua.itaysonlab.tgkit.preference.types.TGKitTextIconRow
import android.content.Intent
import android.net.Uri

class GPDonateEntry : BasePreferencesEntry {
    override fun getPreferences(bf: BaseFragment) = tgKitScreen(LocaleController.getString("CG_GooglePlay_Donate", R.string.CG_GooglePlay_Donate)) {
        category(LocaleController.getString("CG_GooglePlay_Info", R.string.CG_GooglePlay_Info)) {
            textDetail {
                title = LocaleController.getString("CG_GooglePlay_Info", R.string.CG_GooglePlay_Info)
                detail = LocaleController.getString("CG_Donate_Desc", R.string.CG_Donate_Desc)
            }
        }
        category(LocaleController.getString("CG_Donate_Method", R.string.CG_Donate_Method)) {
            textIcon {
                title = "QIWI"
                divider = true

                listener = TGKitTextIconRow.TGTIListener {
                    val openURL = Intent(android.content.Intent.ACTION_VIEW)
                    openURL.data = Uri.parse("https://qiwi.com/n/hackerone228/")
                    bf.parentActivity.startActivity(openURL)
                }
            }
            textIcon {
                title = "DonatePay"
                divider = true

                listener = TGKitTextIconRow.TGTIListener {
                    val openURL = Intent(android.content.Intent.ACTION_VIEW)
                    openURL.data = Uri.parse("https://new.donatepay.ru/@ctwoon")
                    bf.parentActivity.startActivity(openURL)
                }
            }
            textIcon {
                title = LocaleController.getString("CG_Mono_Desc", R.string.CG_Mono_Desc)
                divider = true

                listener = TGKitTextIconRow.TGTIListener {
                    AndroidUtilities.addToClipboard("5375414117420108")
                }
            }
        }
    }
}