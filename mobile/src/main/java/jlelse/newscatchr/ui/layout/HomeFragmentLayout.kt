/*
 * NewsCatchr  Copyright (C) 2016  Jan-Lukas Else
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package jlelse.newscatchr.ui.layout

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.google.android.flexbox.FlexboxLayout
import com.mcxiaoke.koi.ext.dpToPx
import jlelse.newscatchr.extensions.flexboxLayout
import jlelse.newscatchr.extensions.swipeRefreshLayout
import jlelse.newscatchr.ui.fragments.HomeFragment
import jlelse.readit.R
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.nestedScrollView

class HomeFragmentLayout : AnkoComponent<HomeFragment> {

	override fun createView(ui: AnkoContext<HomeFragment>): View = with(ui) {
		swipeRefreshLayout {
			id = R.id.homefragment_refresh
			nestedScrollView {
				id = R.id.homefragment_scrollview
				verticalLayout {
					lparams(width = matchParent, height = wrapContent)
					recyclerView {
						lparams(width = matchParent, height = wrapContent)
						id = R.id.homefragment_recyclerone
						isNestedScrollingEnabled = false
						layoutManager = LinearLayoutManager(ui.owner.context)
					}
					recyclerView {
						lparams(width = matchParent, height = wrapContent)
						id = R.id.homefragment_recyclertwo
						isNestedScrollingEnabled = false
						layoutManager = LinearLayoutManager(ui.owner.context)
					}
					recyclerView {
						lparams(width = matchParent, height = wrapContent)
						id = R.id.homefragment_recyclerthree
						isNestedScrollingEnabled = false
						layoutManager = LinearLayoutManager(ui.owner.context)
					}
					include<View>(R.layout.recyclerheaderitem)
					flexboxLayout {
						lparams(width = matchParent, height = wrapContent) {
							bottomMargin = 16.dpToPx()
							setPadding(12.dpToPx(), 0, 12.dpToPx(), 0)
							visibility = View.GONE
						}
						id = R.id.homefragment_tagsbox
						flexWrap = FlexboxLayout.FLEX_WRAP_WRAP
						justifyContent = FlexboxLayout.JUSTIFY_CONTENT_FLEX_START
					}
				}
			}
		}
	}

}
