/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.annotations.whatandwhy;

public class AnnotationDemoService implements LegacyInfoProvider {

    @ModernInfo
    @Override
    public String info() {
        return "legacy api fetching information";
    }

    @Override
    @SecondaryData
    public String data() {
        return "primary data";
    }
}
