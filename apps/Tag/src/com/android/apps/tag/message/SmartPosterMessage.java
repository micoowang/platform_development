/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.apps.tag.message;

import com.android.apps.tag.record.SmartPoster;
import com.android.apps.tag.record.TextRecord;
import com.google.common.base.Preconditions;

import java.util.Locale;

/**
 * A message consisting of one {@link SmartPoster} object.
 */
class SmartPosterMessage implements ParsedNdefMessage {
    private final SmartPoster mPoster;

    SmartPosterMessage(SmartPoster poster) {
        mPoster = Preconditions.checkNotNull(poster);
    }

    @Override
    public String getSnippet(Locale locale) {
        TextRecord title = mPoster.getTitle();
        if (title == null) {
            return mPoster.getUriRecord().getUri().toString();
        }
        return title.getText();
    }

    @Override
    public boolean isStarred() {
        return false;
    }
}
